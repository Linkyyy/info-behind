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

    public List<Speciality> find(){
        return specialityMapper.find();
    }
}
