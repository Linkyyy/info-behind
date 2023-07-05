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

    @PostMapping("/addGrade")
    @ResponseBody
    public Result addGrade(int gradeId, int specialityId, String gradeName) {
        try {
            gradeService.addGrade(gradeId, specialityId, gradeName);
            return Result.ok().data(null).message("提交成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error().data(null).message("提交失败！" + e.getMessage());
        }
    }

    @PostMapping("/deleteGrade")
    public Result deleteGrade(Integer gradeId) {
        try {
            int rowsAffected = gradeService.deleteGrade(gradeId);
            if (rowsAffected > 0) {
                return Result.ok().data(null).message("删除成功！");
            } else {
                return Result.error().data(null).message("删除失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error().data(null).message("删除失败：" + e.getMessage());
        }
    }

    /**
     * 调试失败
     */
    @PostMapping("/editGrade")
    @ResponseBody
    public Result updateGrade(int gradeId, int specialityId, String gradeName) {
        try {
            gradeService.updateGrade(gradeId, specialityId, gradeName);
            return Result.ok().data(null).message("修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error().data(null).message("修改失败！" + e.getMessage());
        }
    }
}
