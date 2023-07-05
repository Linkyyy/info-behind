package com.example.info.service;

import com.example.info.mapper.ExamPlanMapper;
import com.example.info.poji.ExamPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamPlanService {
    @Autowired
    public ExamPlanMapper examPlanMapper;

    public List<ExamPlan> find(int page, int pageSize){
        int index = (page-1)*pageSize;
        return this.examPlanMapper.find(index,pageSize);
    }
}
