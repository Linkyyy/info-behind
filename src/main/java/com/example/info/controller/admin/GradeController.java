package com.example.info.controller.admin;

import com.example.info.poji.Grade;
import com.example.info.service.GradeService;
import com.example.info.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @GetMapping("/getGrade")
    public Result getGrade(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        System.out.println(page);
        List<Grade> gradeList = gradeService.find(page, pageSize);
        return Result.ok().data(gradeList).message("查询成功！");
    }

    @PostMapping("/deleteGrade")
    public Result deleteGrade(Integer gradeId) {
        try {
            int rowsAffected = gradeService.deleteGrade(gradeId);
            if (rowsAffected > 0) {
                return Result.ok().data(null).message("删除成功！");
            } else {
                return Result.error().data(null).message("删除失败！！！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error().data(null).message("删除失败：" + e.getMessage());
        }
    }
}
