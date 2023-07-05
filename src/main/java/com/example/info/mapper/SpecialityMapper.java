package com.example.info.mapper;

import com.example.info.poji.Educational;
import com.example.info.poji.Speciality;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SpecialityMapper {

    @Select("select * from speciality where isDel=0 limit #{index},#{pageSize}")
    @Results({
            @Result(column = "specialityId",property = "specialityId"),
            @Result(column = "specialityName",property = "specialityName"),
            @Result(column = "creator",property = "creator"),
            @Result(column = "createDate",property = "createDate"),
            @Result(column = "isDel",property = "isDel"),
            @Result(
                    property = "educational",             // 被包含对象的变量名
                    javaType = Educational.class,    // 被包含对象的实际数据类型
                    column = "educationalId",             // 根据查询出的中间表中的sid字段来查询student表
                    /*
                        one、@One 一对一固定写法
                        select属性：指定调用哪个接口中的哪个方法
                     */
                    one = @One(select = "com.example.info.mapper.EducationalMapper.findById")
            ),

    })
    public List<Speciality> find(int index,int pageSize);

    @Select("select * from speciality where specialityId=#{specialityId}")
    public Speciality findById(int specialityId);

    @Update("UPDATE speciality SET isDel = 1 WHERE specialityId = #{specialityId} AND isDel=0")
    public int deleteSpeciality(int specialityId);

    @Insert("INSERT INTO speciality (specialityId, educationalId, specialityName, creator, createDate, isDel) " +
            "VALUES (#{specialityId}, #{educationalId}, #{specialityName}, 'admin', NOW(), 0)")
    public void addSpeciality(@Param("specialityId") int specialityId,
                       @Param("educationalId") int educationalId,
                       @Param("specialityName") String specialityName);

    @Update("UPDATE speciality SET educationalId = #{educationalId}, specialityName = #{specialityName}, " +
            "creator = 'admin', createDate = NOW(), isDel = 0 WHERE specialityId = #{specialityId} AND isDel = 0")
    public void updateSpeciality(@Param("specialityId") int specialityId, @Param("educationalId") int educationalId, @Param("specialityName") String specialityName);
}
