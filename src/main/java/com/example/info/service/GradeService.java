package com.example.info.service;

import com.example.info.mapper.GradeMapper;
import com.example.info.poji.Grade;
import com.example.info.poji.Speciality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    @Autowired
    private GradeMapper gradeMapper;

    public List<Grade> find(){
        return gradeMapper.find();
    }
}
