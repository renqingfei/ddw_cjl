package com.example.ddw_cjl.dao;

import com.example.ddw_cjl.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Userdao {
    @Select("select * from user where email=#{email} ")
    public User login(@Param("email") String email);
    @Insert("insert into user set email=#{email},password=#{password},nickname=#{nickname},status=#{status},code=#{code},create_date=#{create_date}")
    public int add(User user);
    @Select("select * from user")
    public List<User> QueryAll();
    @Select("select * from user where id=#{id}")
    public User selectOneUser(int id);
    @Update("update user set status=#{status} where id=#{id}")
    public int updateuser(User user);
}
