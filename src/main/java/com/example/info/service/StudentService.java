package com.example.info.service;

import com.example.info.mapper.StudentMapper;
import com.example.info.poji.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public List<Student> find(int page, int pageSize){
        int index = (page-1)*pageSize;
        return this.studentMapper.find(index,pageSize);
    }
}
