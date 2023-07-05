package com.example.info.mapper;

import com.example.info.poji.Educational;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EducationalMapper {

    @Select("select * from educational where isDel=0 limit #{index},#{pageSize}")
    public List<Educational> find(int index,int pageSize);

    @Select("select * from educational where educationalId=#{educationalId}")
    public Educational findById(int educationalId);

    @Insert("INSERT INTO educational (educationalId, educationalName, description, creator, createDate, isDel) " +
            "VALUES (#{educationalId}, #{educationalName}, #{description}, 'admin', NOW(), 0)")
    public void addEducational(@Param("educationalId") int educationalId,
                        @Param("educationalName") String educationalName,
                        @Param("description") String description);

    @Update("UPDATE educational SET isDel = 1 WHERE educationalId = #{educationalId} AND isDel=0")
    public int deleteEducational(int educationalId);

    @Update("UPDATE educational SET educationalName = #{educationalName}, description = #{description}, creator = 'admin', createDate = NOW(), isDel = 0 " +
            "WHERE educationalId = #{educationalId} AND isDel = 0")
    void updateEducational(@Param("educationalId") int educationalId,
                           @Param("educationalName") String educationalName,
                           @Param("description") String description);

}
