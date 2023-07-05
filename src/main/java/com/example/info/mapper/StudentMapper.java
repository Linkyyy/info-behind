package com.example.info.mapper;

import com.example.info.poji.Grade;
import com.example.info.poji.Speciality;
import com.example.info.poji.Student;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    @Select("select * from student")
    @Results({
            @Result(column = "stuId",property = "stuId"),
            @Result(column = "stuName",property = "stuName"),
            @Result(column = "password",property = "password"),
            @Result(column = "phone",property = "phone"),
            @Result(column = "email",property = "email"),
            @Result(column = "photo",property = "photo"),
            @Result(column = "status",property = "status"),
            @Result(column = "creator",property = "creator"),
            @Result(column = "createDate",property = "createDate"),
            @Result(column = "isDel",property = "isDel"),
            @Result(
                    property = "grade",             // 被包含对象的变量名
                    javaType = Grade.class,    // 被包含对象的实际数据类型
                    column = "gradeId",             // 根据查询出的中间表中的sid字段来查询student表
                    /*
                        one、@One 一对一固定写法
                        select属性：指定调用哪个接口中的哪个方法
                     */
                    one = @One(select = "com.example.info.mapper.GradeMapper.findById")
            ),

    })
    public List<Student> find();

    @Select("select * from student where stuId=#{stuId}")
    public Student findById(int stuId);
}
