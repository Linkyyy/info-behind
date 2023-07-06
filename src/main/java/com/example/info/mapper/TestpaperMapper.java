package com.example.info.mapper;

import com.example.info.poji.Speciality;
import com.example.info.poji.Testpaper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TestpaperMapper {
    @Select("select * from testpaper where isDel=0 limit #{index},#{pageSize}")
    @Results({
            @Result(column = "paperId",property = "paperId"),
            @Result(column = "paperName",property = "paperName"),
            @Result(column = "total",property = "total"),
            @Result(column = "createDate",property = "createDate"),
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
    public List<Testpaper> find(int index, int pageSize);

    @Select("select * from testpaper where paperId=#{paperId}")
    public Testpaper findById(int paperId);
}
