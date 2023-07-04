package com.example.info.service.Impl;

import com.example.info.mapper.UserMapper;
import com.example.info.poji.User;
import com.example.info.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> find() {
        return userMapper.find();
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User adminLogin(String username, String password){

        return userMapper.adminLogin(username, password);
    }

}
