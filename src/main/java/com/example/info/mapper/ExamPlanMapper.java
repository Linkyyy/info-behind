package com.example.info.mapper;

import com.example.info.poji.ExamPlan;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ExamPlanMapper {
    @Select("select * from ExamPlan where isDel=0 limit #{index},#{pageSize}")
    public List<ExamPlan> find(int index, int pageSize);

    @Select("select * from ExamPlan where id=#{id}")
    public ExamPlan findById(int id);
}
