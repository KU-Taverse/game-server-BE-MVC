package com.kutaverse.demo.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kutaverse.demo.domain.MapRequestType;
import com.kutaverse.demo.domain.User;
import com.kutaverse.demo.dto.UserRequestDto;
import com.kutaverse.demo.dto.UserResponseDto;
import com.kutaverse.demo.repository.UserRepository;
import com.kutaverse.demo.service.UserService;
import com.kutaverse.demo.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class WebSocketHandler extends TextWebSocketHandler {

    private static final ConcurrentHashMap<String, WebSocketSession> CLIENTS = new ConcurrentHashMap<>();
    private final UserService userService;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        CLIENTS.put(session.getId(), session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        CLIENTS.remove(session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        ObjectMapper objectMapper=new ObjectMapper();
        UserRequestDto userRequestDto = objectMapper.readValue(message.asBytes(), UserRequestDto.class);
        if(userRequestDto.getMapRequestType()== MapRequestType.SAVE){
            User entity = userRequestDto.toEntity();
            userService.save(entity);
        }
        else if(userRequestDto.getMapRequestType()==MapRequestType.DELETE){
            userService.delete(userRequestDto.getUserId());
        }

        /*String id = session.getId();  //메시지를 보낸 아이디

        CLIENTS.entrySet().forEach( arg->{
            if(!arg.getKey().equals(id)) {  //같은 아이디가 아니면 메시지를 전달합니다.
                try {

                    //arg.getValue().sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });*/
    }

    @Scheduled(fixedDelay = 16)
    private void boardCastMessage(){
        List<User> userList = userService.findAll();
        String response = JsonUtil.userListToJson(userList);
        CLIENTS.entrySet().forEach(arg -> {
            try {
                arg.getValue().sendMessage(new TextMessage(response));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}