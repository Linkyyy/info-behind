package com.example.info.mapper;

import com.example.info.poji.Testpaper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TestpaperMapper {
    @Select("select * from testpaper where isDel=0 limit #{index},#{pageSize}")
    public List<Testpaper> find(int index, int pageSize);

    @Select("select * from testpaper where paperId=#{paperId}")
    public Testpaper findById(int paperId);
}
