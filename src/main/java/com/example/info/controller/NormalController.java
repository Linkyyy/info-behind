package com.example.info.controller;

import com.example.info.service.NormalService;
import com.example.info.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController

public class NormalController {
    @Autowired
    private NormalService normalService;

    @GetMapping("/admin/getData")
    public Result getData(){
        return Result.ok().data(normalService.getData());
    }

    @PostMapping("/admin/login")
    public Result adminLogin(@RequestBody Map<String, String> map) {
        String adminName = map.get("adminName");
        String password = map.get("password");

        try {
            return normalService.adminLogin(adminName, password);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error().data(null).message("登录异常！"+ e.getMessage());
        }
    }

    @PostMapping("/user/login")
    public Result stuLogin(@RequestBody Map<String, String> map) {
        int stuId = Integer.parseInt(map.get("stuId"));
        String password = map.get("password");

        try {
            return normalService.stuLogin(stuId, password);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error().data(null).message("登录异常！"+e.getMessage());
        }
    }
}
