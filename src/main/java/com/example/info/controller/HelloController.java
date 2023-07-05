package com.example.info.controller;

import com.example.info.poji.User;
import com.example.info.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String hello(){
        return "hello world!";
    }

    @GetMapping("/user")
    public List<User> user(){
       return userService.find();
    }

    @GetMapping("/inputUser")
    public int inputUser(User user){
        return userService.insert(user);
    }

    @GetMapping("/map")
    public Map<String, Object> map(){
        Map<String, Object> m =new HashMap<>();
        User user =new User(1,"wdd","qq22212");
        m.put("用户信息",user);
        m.put("其他信息","hahah");
        return m;
    }

}
