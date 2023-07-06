package com.example.info.controller;

import com.example.info.service.NormalService;
import com.example.info.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class NormalController {
    @Autowired
    private NormalService normalService;
    @GetMapping("/admin/getData")
    public Result getData(){


        return Result.ok().data(normalService.getData());
    }

}
