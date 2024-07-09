package com.kutaverse.demo.repository;

import com.kutaverse.demo.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final Map<String,User> map;

    public User save(User user) {
        User saveUser = map.put(user.getUserId(), user);
        if(saveUser==null)
            return user;
        return saveUser;
    }
    public List<User> findAll(){
        return map.values().stream().toList();
    }
}
