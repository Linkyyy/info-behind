package com.example.info.controller.admin;

import com.example.info.poji.Speciality;
import com.example.info.service.SpecialityService;
import com.example.info.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    @PostMapping("/deleteSpeciality")
    public Result deleteSpeciality(@RequestParam int specialityId){
        try {
            // 调用Service层的方法来删除数据
            boolean isDeleted = specialityService.deleteSpeciality(specialityId);
            if (isDeleted) {
                return Result.ok().data(null).message("删除成功！");
            } else {
                return Result.error().data(null).message("删除失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error().data(null).message("删除失败！发生异常：" + e.getMessage());
        }
    }

    @PostMapping("/addSpeciality")
    public Result addSpeciality(@RequestParam int specialityId, @RequestParam int educationalId, @RequestParam String specialityName) {
        try {
            specialityService.addSpeciality(specialityId, educationalId, specialityName);
            return Result.ok().data(new HashMap<>()).message("提交成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error().data(new HashMap<>()).message("提交失败！" + e.getMessage());
        }
    }

    @PostMapping("/editSpeciality")
    public Result updateSpeciality(@RequestParam int specialityId, @RequestParam int educationalId, @RequestParam String specialityName) {
        try {
            specialityService.updateSpeciality(specialityId, educationalId, specialityName);
            return Result.ok().data(new HashMap<>()).message("修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error().data(new HashMap<>()).message("请先登录！" + e.getMessage());
        }
    }
}
