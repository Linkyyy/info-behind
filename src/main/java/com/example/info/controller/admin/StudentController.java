package com.example.info.controller.admin;

import com.example.info.poji.Speciality;
import com.example.info.poji.Student;
import com.example.info.service.SpecialityService;
import com.example.info.service.StudentService;
import com.example.info.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("getStudent")
    public Result getStudent(){
        List<Student> studentList=studentService.find();
        return Result.ok().data(studentList);
    }
}
