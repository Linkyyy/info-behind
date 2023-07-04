package com.example.info.mapper;

import com.example.info.poji.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    public List<User> find();

    @Insert("insert into user(id,username,password) values(#{id},#{username},#{password})")
    public int insert(User user);

}