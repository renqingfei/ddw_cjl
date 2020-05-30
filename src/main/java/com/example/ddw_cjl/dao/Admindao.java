package com.example.ddw_cjl.dao;

import com.example.ddw_cjl.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface Admindao {
    @Select("select * from admin where username=#{username} and password=#{password}")
  public Admin login(@Param("username") String username,@Param("password") String password);
}
