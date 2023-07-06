package com.example.info.service;

import com.example.info.mapper.UserMapper;
import com.example.info.poji.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> find() {
        return userMapper.find();
    }

    public int insert(User user) {
        return userMapper.insert(user);
    }

    public User login(String username, String password) {
        return userMapper.login(username, password);
    }
}
