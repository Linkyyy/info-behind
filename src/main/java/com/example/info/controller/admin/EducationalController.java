package com.example.info.controller.admin;

import com.example.info.poji.Educational;
import com.example.info.service.EducationalService;
import com.example.info.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class EducationalController {

    @Autowired
    private EducationalService educationalService;

    @GetMapping("/getEducational")
    public Result getEducational(@RequestParam(value = "page", defaultValue = "1") int page,@RequestParam(value = "pageSize", defaultValue = "10")int pageSize){
        System.out.println(page);
        List<Educational> list= educationalService.find(page,pageSize);
        return Result.ok().data(list).message("查询成功！");
    }

    @PostMapping("/addEducational")
    public Result addEducational(@RequestParam int educationalId, @RequestParam String educationalName, @RequestParam String description) {
        try {
            educationalService.addEducational(educationalId, educationalName, description);
            return Result.ok().data(null).message("提交成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error().data(null).message("提交失败！发生异常：" + e.getMessage());
        }
    }

    @GetMapping("/deleteEducational")
    public Result deleteEducational(int educationalId) {
        try {
            // 调用Service层的方法来删除数据
            boolean isDeleted = educationalService.deleteEducational(educationalId);
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

    @PostMapping("/editEducational")
    public Result updateEducational(@RequestParam int educationalId,
                                    @RequestParam String educationalName,
                                    @RequestParam String description) {
        try {
            // 调用Service层的方法来修改数据
            educationalService.updateEducational(educationalId, educationalName, description);
            return Result.ok().data(null).message("修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error().data(null).message("修改失败！发生异常：" + e.getMessage());
        }
    }

}
