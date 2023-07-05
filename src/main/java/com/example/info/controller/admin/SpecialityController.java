package com.example.info.controller.admin;

import com.example.info.poji.Speciality;
import com.example.info.service.SpecialityService;
import com.example.info.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class SpecialityController {
    @Autowired
    private SpecialityService specialityService;

    @GetMapping("/getSpeciality")
    public Result getSpeciality(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "pageSize", defaultValue = "10")int pageSize){
        System.out.println(page);
        List<Speciality> list= specialityService.find(page,pageSize);
        return Result.ok().data(list).message("查询成功！");
    }
}
