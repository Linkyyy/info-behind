package com.example.info.mapper;

import com.example.info.poji.Grade;
import com.example.info.poji.Speciality;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GradeMapper {
    @Select("select * from grade where isDel=0 limit #{index},#{pageSize}")
    @Results({
            @Result(column = "gradeId",property = "gradeId"),
            @Result(column = "gradeName",property = "gradeName"),
            @Result(column = "creator",property = "creator"),
            @Result(column = "createDate",property = "createDate"),
            @Result(column = "isDel",property = "isDel"),
            @Result(
                    property = "speciality",             // 被包含对象的变量名
                    javaType = Speciality.class,    // 被包含对象的实际数据类型
                    column = "specialityId",             // 根据查询出的中间表中的sid字段来查询student表
                    /*
                        one、@One 一对一固定写法
                        select属性：指定调用哪个接口中的哪个方法
                     */
                    one = @One(select = "com.example.info.mapper.SpecialityMapper.findById")
            ),

    })
    public List<Grade> find(int index, int pageSize);

    @Select("select * from grade where gradeId=#{gradeId}")
    public Grade findById(int gradeId);

    @Update("UPDATE grade SET isDel = 1 WHERE gradeId = #{gradeId} AND isDel=0")
    public int deleteGrade(@Param("gradeId") int gradeId);

}
