package com.example.info.service;

import com.example.info.mapper.UserMapper;
import com.example.info.poji.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public List<User> find();
    public int insert(User user);
}
