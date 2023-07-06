package com.example.info.service;

import com.example.info.mapper.NormalMapper;
import com.example.info.poji.AdminInfo;
import com.example.info.poji.Student;
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

    public AdminInfo adminLogin(String adminName, String password) {
        return normalMapper.adminLogin(adminName, password);
    }

    public Student stuLogin(String stuId, String password) {
        return normalMapper.stuLogin(stuId, password);
    }



}
