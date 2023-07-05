package com.example.info.controller.admin;

import com.example.info.poji.ExamPlan;
import com.example.info.service.ExamPlanService;
import com.example.info.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class ExamPlanController {
    @Autowired
    public ExamPlanService planService;

    @GetMapping("/getExamPlan")
    @ResponseBody
    public Result getEducational(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "pageSize", defaultValue = "10")int pageSize){
        System.out.println(page);
        List<ExamPlan> list= planService.find(page,pageSize);
        return Result.ok().data(list).message("查询成功！");
    }
}
