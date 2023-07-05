package com.example.info.controller.admin;

import com.example.info.poji.Grade;
import com.example.info.poji.Speciality;
import com.example.info.service.GradeService;
import com.example.info.service.SpecialityService;
import com.example.info.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @GetMapping("getGrade")
    public Result getGrade(){
        List<Grade> gradeList=gradeService.find();
        return Result.ok().data(gradeList);
    }
}
