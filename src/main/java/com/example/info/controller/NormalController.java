package com.example.info.controller;

import com.example.info.service.NormalService;
import com.example.info.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class NormalController {
    @Autowired
    private NormalService normalService;

    @GetMapping("/admin/getData")
    public Result getData(){
        return Result.ok().data(normalService.getData());
    }

    @PostMapping("/admin/login")
    @ResponseBody
    public Result adminLogin(String adminName, String password) {
        try {
            return normalService.adminLogin(adminName, password);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error().data(null).message("登录异常！");
        }
    }
}
