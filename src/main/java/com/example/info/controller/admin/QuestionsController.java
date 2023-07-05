package com.example.info.controller.admin;

import com.example.info.poji.Questions;
import com.example.info.service.QuestionsService;
import com.example.info.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class QuestionsController {
    @Autowired
    private QuestionsService questionsService;

    @GetMapping("/getQuestions")
    @ResponseBody
    public Result getQuestions(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "pageSize", defaultValue = "10")int pageSize){
        System.out.println(page);
        List<Questions> list= questionsService.find(page,pageSize);
        return Result.ok().data(list).message("查询成功！");
    }

    @GetMapping("/getQuestions/{specialityId}")
    @ResponseBody
    public Result getQuestionsBySpecialityId(@PathVariable int specialityId,
                                             @RequestParam(value = "page", defaultValue = "1") int page,
                                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        try {
            List<Questions> questions = questionsService.getQuestionsBySpecialityId(specialityId, page, pageSize);
            return Result.ok().data(questions).message("查询成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error().data(null).message("查询失败！"+e.getMessage());
        }
    }
}
