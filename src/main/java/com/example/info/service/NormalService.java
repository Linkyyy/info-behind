package com.example.info.service;

import com.example.info.mapper.NormalMapper;
import com.example.info.poji.AdminInfo;
import com.example.info.poji.Student;
import com.example.info.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class NormalService {
    @Autowired
    private NormalMapper normalMapper;

    public Map<String,Integer> getData(){
        Map<String,Integer> map=new HashMap<>();

        map.put("educationalCount",normalMapper.geteducationalCount());
        map.put("specialityCount",normalMapper.getspecialityCount());
        map.put("gradeCount",normalMapper.getgradeCount());
        map.put("studentCount",normalMapper.getstudentCount());
        map.put("questionsCount", normalMapper.getquestionsCount());
        map.put("testpaperCount", normalMapper.gettestpaperCount());
        map.put("examPlanCount", normalMapper.getExamPlanCount());
        return map;
    }

    public Result adminLogin(String adminName, String password) {
        AdminInfo adminInfo = normalMapper.adminlogin(adminName, password);
        if (adminInfo != null) {
            return Result.ok().data(adminInfo).message("登录成功！");
        } else {
            return Result.error().data(null).message("账号或密码错误！");
        }
    }

    public Result stuLogin(int stuId, String password) {
        Student student = normalMapper.stuLogin(stuId, password);
        if (student != null) {
            return Result.ok().data(student).message("登录成功！");
        } else {
            return Result.error().data(null).message("账号或密码错误！");
        }
    }

}
