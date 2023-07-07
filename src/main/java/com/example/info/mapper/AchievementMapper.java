package com.example.info.mapper;

import com.example.info.poji.Achievement;
import com.example.info.poji.ExamPlan;
import com.example.info.poji.Student;
import com.example.info.poji.Testpaper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AchievementMapper {
    @Select("select * from achievement limit #{index},#{pageSize}")
    @Results({
            @Result(column = "resultId",property = "resultId"),
            @Result(column = "score",property = "score"),
            @Result(
                    property = "examPlan",             // 被包含对象的变量名
                    javaType = ExamPlan.class,    // 被包含对象的实际数据类型
                    column = "id",             // 根据查询出的中间表中的pid字段来查询student表
                    /*
                        one、@One 一对一固定写法
                        select属性：指定调用哪个接口中的哪个方法
                     */
                    one = @One(select = "com.example.info.mapper.ExamPlanMapper.findById")
            ),
            @Result(
                    property = "student",
                    javaType = Student.class,
                    column = "stuId",
                    one = @One(select = "com.example.info.mapper.StudentMapper.findById")
            ),
            @Result(
                    property =  "testpaper",
                    javaType = Testpaper.class,
                    column = "paperId",
                    one = @One(select = "com.example.info.mapper.TestpaperMapper.findById")
            )
    })
    public List<Achievement> find(int index, int pageSize);

    @Select("select * from achievement where stuId=#{stuId}")
    public Achievement findById(int stuId);
}
