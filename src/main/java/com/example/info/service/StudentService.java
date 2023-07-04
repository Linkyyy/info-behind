package com.example.info.service;

import com.example.info.mapper.StudentMapper;
import com.example.info.poji.Grade;
import com.example.info.poji.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public List<Student> find(){
        return studentMapper.find();
    }
}
