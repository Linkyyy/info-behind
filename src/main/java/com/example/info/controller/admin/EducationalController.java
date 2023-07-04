package com.example.info.controller.admin;

import com.example.info.poji.Educational;
import com.example.info.service.EducationalService;
import com.example.info.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class EducationalController {

    @Autowired
    private EducationalService educationalService;

    @GetMapping("/getEducational")
    public Result getEducational(){
        List<Educational> list= educationalService.find();
        return Result.ok().data(list).message("查询成功！");
    }
    @PostMapping("/addEducational")
    public int addEducational(){

        return 0;
    }

}
