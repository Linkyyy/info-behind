package com.example.info.mapper;

import com.example.info.poji.AdminInfo;
import com.example.info.poji.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
    public AdminInfo adminlogin(@Param("adminName") String adminName, @Param("password") String password);

    @Select("SELECT * FROM student WHERE stuId = #{stuId} AND password = #{password}")
    public Student stuLogin(@Param("stuId") int stuId, @Param("password") String password);
}
