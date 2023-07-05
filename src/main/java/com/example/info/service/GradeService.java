package com.example.info.service;

import com.example.info.mapper.GradeMapper;
import com.example.info.poji.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    @Autowired
    private GradeMapper gradeMapper;

    public List<Grade> find(int page,int pageSize){
        int index = (page-1)*pageSize;
        return gradeMapper.find(index, pageSize);
    }

    public int deleteGrade(int gradeId) {
        return gradeMapper.deleteGrade(gradeId);
    }
}
