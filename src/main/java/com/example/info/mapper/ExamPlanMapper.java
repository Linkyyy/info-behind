package com.example.info.mapper;

import com.example.info.poji.ExamPlan;
import com.example.info.poji.Grade;
import com.example.info.poji.Testpaper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ExamPlanMapper {
    @Select("select * from ExamPlan where isDel=0 limit #{index},#{pageSize}")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "beginTime",property = "beginTime"),
            @Result(column = "endTime",property = "endTime"),
            @Result(column = "creator",property = "creator"),
            @Result(column = "createDate",property = "createDate"),
            @Result(column = "isDel",property = "isDel"),
            @Result(
                    property = "testpaper",             // 被包含对象的变量名
                    javaType = Testpaper.class,    // 被包含对象的实际数据类型
                    column = "paperId",             // 根据查询出的中间表中的pid字段来查询student表
                    /*
                        one、@One 一对一固定写法
                        select属性：指定调用哪个接口中的哪个方法
                     */
                    one = @One(select = "com.example.info.mapper.TestpaperMapper.findById")
            ),
            @Result(
                    property = "grade",
                    javaType = Grade.class,
                    column = "gradeId",
                    one = @One(select = "com.example.info.mapper.GradeMapper.findById")
            )
    })
    public List<ExamPlan> find(int index, int pageSize);

    @Select("select * from ExamPlan where id=#{id}")
    public ExamPlan findById(int id);
}
