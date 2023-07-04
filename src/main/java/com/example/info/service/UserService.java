package com.example.info.service;

import com.example.info.poji.User;

import java.util.List;


public interface UserService {
    public List<User> find();
    public int insert(User user);
    public User adminLogin(String username, String password);



}
