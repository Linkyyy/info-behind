package com.example.info.controller;

import com.example.info.poji.LoginDTO;
import com.example.info.poji.User;
import com.example.info.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    @PostMapping("/api/admin/login")
    public Map<String, Object> adminLogin(LoginDTO loginDTO) {
        System.out.println("进入请求");
        User user = userService.adminLogin(loginDTO.getUsername(), loginDTO.getPassword());
        Map<String, Object> m =new HashMap<>();
        if (Objects.isNull(user)){
            m.put("code",0);
            m.put("message","账号或密码错误！");
            m.put("data",null);
            return m;
        }
        m.put("code",20000);
        m.put("message","登录成功！");

        Map<String, Object> m2 =new HashMap<>();
        m2.put("adminId",user.getId());
        m2.put("adminName",user.getUsername());
        m2.put("password",user.getPassword());
        m.put("data",m2);
        return m;
    }


}
