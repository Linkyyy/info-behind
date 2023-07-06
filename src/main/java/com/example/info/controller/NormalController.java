package com.example.info.controller;

import com.example.info.poji.AdminInfo;
import com.example.info.poji.ExamPlan;
import com.example.info.poji.Questions;
import com.example.info.poji.Student;
import com.example.info.service.ExamPlanService;
import com.example.info.service.NormalService;
import com.example.info.service.QuestionsService;
import com.example.info.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class NormalController {
    @Autowired
    private NormalService normalService;

    @Autowired
    private ExamPlanService examPlanService;

    @Autowired
    private QuestionsService questionsService;

    @GetMapping("/admin/getData")
    public Result getData(){
        return Result.ok().data(normalService.getData());
    }

    @PostMapping("/admin/login")
    public Result adminLogin(@RequestBody Map<String, String> map) {
        String adminName = map.get("adminName");
        String password = map.get("password");

        try {
            AdminInfo adminInfo = normalService.adminLogin(adminName, password);
            if (adminInfo != null) {
                return Result.ok().data(adminInfo).message("登录成功！");
            } else {
                return Result.error().data(null).message("账号或密码错误！");
            }        } catch (Exception e) {
            e.printStackTrace();
            return Result.error().data(null).message("登录异常！"+ e.getMessage());
        }
    }

    @PostMapping("/user/login")
    public Result stuLogin(@RequestBody Map<String, String> map) {
        String stuId = map.get("stuId");
        String password = map.get("password");

        try {
            Student student = normalService.stuLogin(stuId, password);

            if (student != null) {
                if(student.getAchievement()==null){
                    return Result.ok().data(student).message("登录成功！");
                }
                else{
                    int gradeId=student.getGrade().getGradeId();
                    System.out.println(gradeId);
                    ExamPlan examPlan= examPlanService.findByGradeId(gradeId);
                    int paperId=examPlan.getTestpaper().getPaperId();
                    List<Questions> questionsList= questionsService.getQuestionsByPaperId(paperId);
                    Map<String,Object> dataMap=new HashMap<>();
                    dataMap.put("student",student);
                    dataMap.put("examPlan",examPlan);
                    dataMap.put("questionsList",questionsList);
                    return Result.ok().data(dataMap).message("登录成功！");
                }



            } else {
                return Result.error().data(null).message("账号或密码错误！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error().data(null).message("登录异常！"+e.getMessage());
        }
    }


}
