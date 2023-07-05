package com.example.info.service;

import com.example.info.mapper.EducationalMapper;
import com.example.info.poji.Educational;
import com.example.info.service.EducationalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationalService {


    @Autowired
    public EducationalMapper educationalMapper;

    public List<Educational> find(){
        return this.educationalMapper.find();
    }
}