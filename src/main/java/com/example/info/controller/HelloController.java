package com.example.info.controller;

import com.example.info.poji.User;
import com.example.info.service.UserService;
import com.example.info.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestParam String username, @RequestParam String password) {
        try {
            User user = userService.login(username, password);
            if (user != null) {
                // 登录成功
                Map<String, Object> data = new HashMap<>();
                data.put("adminId", String.valueOf(user.getId()));
                data.put("adminName", user.getUsername());
                data.put("password", user.getPassword());
                data.put("phone", "1231232132");

                return Result.ok().data(data).message("登录成功！");
            } else {
                // 账号或密码错误
                return Result.error().data(null).message("账号或密码错误！");
            }
        } catch (Exception e) {
            // 打印异常信息
            e.printStackTrace();
            return Result.error().data(null).message("登录失败！");
        }
    }

}
