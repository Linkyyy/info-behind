package com.example.info.service;

import com.example.info.mapper.EducationalMapper;
import com.example.info.poji.Educational;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationalService {
    @Autowired
    public EducationalMapper educationalMapper;

    public List<Educational> find(int page,int pageSize){
        int index = (page-1)*pageSize;
        return this.educationalMapper.find(index,pageSize);
    }

    public void addEducational(int educationalId, String educationalName, String description) {
        educationalMapper.addEducational(educationalId, educationalName, description);
    }

    public boolean deleteEducational(int educationalId) {
        int rowsAffected = educationalMapper.deleteEducational(educationalId);
        return rowsAffected > 0;
    }

    public void updateEducational(int educationalId, String educationalName, String description) {
        educationalMapper.updateEducational(educationalId, educationalName, description);
    }
}