package com.example.info.controller.admin;

import com.example.info.poji.Student;
import com.example.info.service.StudentService;
import com.example.info.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("getStudent")
    public Result getStudent(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "pageSize", defaultValue = "10")int pageSize){
        System.out.println(page);
        List<Student> list= studentService.find(page,pageSize);
        return Result.ok().data(list).message("查询成功！");
    }

    @PostMapping("/deleteStudent")
    public Result deleteStudent(@RequestParam int stuId){
        try {
            // 调用Service层的方法来删除数据
            boolean isDeleted = studentService.deleteStudent(stuId);
            if (isDeleted) {
                return Result.ok().data(null).message("删除成功！");
            } else {
                return Result.error().data(null).message("删除失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error().data(null).message("删除失败！发生异常：" + e.getMessage());
        }
    }
}
