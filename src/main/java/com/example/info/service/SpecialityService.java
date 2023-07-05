package com.example.info.service;

import com.example.info.mapper.SpecialityMapper;
import com.example.info.poji.Speciality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void addSpeciality(int specialityId, int educationalId, String specialityName) {
        specialityMapper.addSpeciality(specialityId, educationalId, specialityName);
    }

    public void updateSpeciality(int specialityId, int educationalId, String specialityName) {
        specialityMapper.updateSpeciality(specialityId, educationalId, specialityName);
    }
}
