package com.example.info.service;

import com.example.info.mapper.SpecialityMapper;
import com.example.info.poji.Speciality;
import com.example.info.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SpecialityService {
    @Autowired
    private SpecialityMapper specialityMapper;

    public List<Speciality> find(int page, int pageSize){
        int index = (page-1)*pageSize;
        return this.specialityMapper.find(index,pageSize);
    }

    public boolean deleteSpeciality(int specialityId) {
        int rowsAffected = specialityMapper.deleteSpeciality(specialityId);
        return rowsAffected > 0;
    }

    @Transactional
    public Result addSpeciality(int specialityId, int educationalId, String specialityName) {
        try {
            specialityMapper.addSpeciality(specialityId, educationalId, specialityName);
            return Result.ok().data(null).message("提交成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error().data(null).message("请先登录！"+e.getMessage());
        }
    }


}
