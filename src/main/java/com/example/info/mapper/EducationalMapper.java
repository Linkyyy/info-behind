package com.example.info.mapper;

import com.example.info.poji.Educational;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EducationalMapper {

    @Select("select * from educational")
    public List<Educational> find();

    @Select("select * from educational where educationalId=#{educationalId}")
    public Educational findById(int educationalId);
}
