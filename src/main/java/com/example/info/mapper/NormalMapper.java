package com.example.info.mapper;

import com.example.info.poji.Achievement;
import com.example.info.poji.AdminInfo;
import com.example.info.poji.Grade;
import com.example.info.poji.Student;
import org.apache.ibatis.annotations.*;

@Mapper
public interface NormalMapper {

    @Select("select count(*) from educational where isDel=0")
    public int geteducationalCount();

    @Select("select count(*) from grade where isDel=0")
    public int getgradeCount();

    @Select("select count(*) from speciality where isDel=0")
    public int getspecialityCount();

    @Select("select count(*) from student where isDel=0")
    public int getstudentCount();

    @Select("select count(*) from questions where isDel=0")
    public int getquestionsCount();

    @Select("select count(*) from testpaper where isDel=0")
    public int gettestpaperCount();

    @Select("select count(*) from ExamPlan where isDel=0")
    public int getExamPlanCount();

    @Select("SELECT * FROM adminInfo WHERE adminName = #{adminName} AND password = #{password}")
    public AdminInfo adminLogin(@Param("adminName") String adminName, @Param("password") String password);

    @Select("SELECT * FROM student WHERE stuId = #{stuId} AND password = #{password}")
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
            @Result(
                    property = "achievement",
                    javaType = Achievement.class,
                    column = "stuId",
                    one = @One(select = "com.example.info.mapper.AchievementMapper.findById")
            )
    })
    public Student stuLogin(@Param("stuId") String stuId, @Param("password") String password);
}
