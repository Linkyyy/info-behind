package com.example.info.mapper;

import com.example.info.poji.Questions;
import com.example.info.poji.Speciality;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionsMapper {
    @Select("select * from questions where isDel=0 limit #{index},#{pageSize}")
    @Results({
            @Result(column = "questionsId",property = "questionsId"),
            @Result(column = "content",property = "content"),
            @Result(column = "optionA",property = "optionA"),
            @Result(column = "optionB",property = "optionB"),
            @Result(column = "optionC",property = "optionC"),
            @Result(column = "optionD",property = "optionD"),
            @Result(column = "category",property = "category"),
            @Result(column = "answer",property = "answer"),
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
    public List<Questions> find(int index, int pageSize);

    @Select("select * from questions where questionsId=#{questionsId}")
    public Questions findById(int questionsId);

    @Select("SELECT * FROM questions WHERE specialityId = #{specialityId} LIMIT #{index}, #{pageSize}")
    public List<Questions> getQuestionsBySpecialityId(@Param("specialityId") int specialityId,
                                               @Param("index") int index,
                                               @Param("pageSize") int pageSize);

    @Select("SELECT * FROM questions WHERE questionsId IN (SELECT questionsId FROM paperContent WHERE paperId = #{paperId})")
    public List<Questions> getQuestionsByPaperId(@Param("paperId") int paperId);

}
