package com.example.info.mapper;

import com.example.info.poji.Questions;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionsMapper {
    @Select("select * from questions where isDel=0 limit #{index},#{pageSize}")
    public List<Questions> find(int index, int pageSize);

    @Select("select * from questions where questionsId=#{questionsId}")
    public Questions findById(int questionsId);

    @Select("SELECT * FROM questions WHERE specialityId = #{specialityId} LIMIT #{index}, #{pageSize}")
    public List<Questions> getQuestionsBySpecialityId(@Param("specialityId") int specialityId,
                                               @Param("index") int index,
                                               @Param("pageSize") int pageSize);
}
