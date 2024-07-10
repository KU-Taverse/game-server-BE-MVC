package com.kutaverse.demo.service;

import com.kutaverse.demo.domain.User;
import com.kutaverse.demo.repository.UserCashRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserCashService {

    private final UserCashRepository userCashRepository;

    public User save(User user) {
        return userCashRepository.save(user);
    }

    public List<User> findAll(){
        return userCashRepository.findAll();
    }

    public String delete(String userId) {
        return userCashRepository.remove(userId);
    }

    @Scheduled(fixedDelay = 10000)
    @Transactional
    public void flushAll(){
        userCashRepository.flushAll();
    }
}
