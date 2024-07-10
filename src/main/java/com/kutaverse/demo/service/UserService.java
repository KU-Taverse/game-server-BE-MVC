package com.kutaverse.demo.service;

import com.kutaverse.demo.domain.User;
import com.kutaverse.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public String delete(String userId) {
        return userRepository.remove(userId);
    }


}
