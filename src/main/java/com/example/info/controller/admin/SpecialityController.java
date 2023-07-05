package com.example.info.controller.admin;

import com.example.info.poji.Speciality;
import com.example.info.service.EducationalService;
import com.example.info.service.SpecialityService;
import com.example.info.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class SpecialityController {
    @Autowired
    private SpecialityService specialityService;

    @GetMapping("getSpeciality")
    public Result getSpeciality(){
        List<Speciality> specialityList=specialityService.find();
        return Result.ok().data(specialityList);
    }
}
