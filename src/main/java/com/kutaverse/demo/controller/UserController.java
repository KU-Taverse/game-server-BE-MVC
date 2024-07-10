package com.kutaverse.demo.controller;

import com.kutaverse.demo.service.UserCashService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserCashService userCashService;

    /**
     * 맵 유저 삭제
     * @param userId 유저 Id
     * @return Mono<Long> 삭제된 유저 Id
     */
    @DeleteMapping("{userId}")
    public String deleteUser(@PathVariable(value = "userId") String userId) {
        return userCashService.delete(userId);
    }
}
