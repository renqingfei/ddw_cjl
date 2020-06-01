package com.example.ddw_cjl.dao;

import com.example.ddw_cjl.entity.Address;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Addressdao {
    @Insert("insert into address values(#{id},#{name},#{local},#{phone},#{zip_code},#{user_id}) ")
    public void addOneAddress(Address address);

     // 查询所有地址
    @Select(" select * from address where user_id=#{id}")
    public List<Address> selectAll(int id);


     // 查单个地址
    @Select("select * from address where id=#{id} ")
    public Address selectOne( int id);
    //修改地址
    @Update("update  address set name=#{name},local=#{local},phone=#{phone},zip_code=#{zip_code} where id=#{id}")
    public void updateone(Address address);
}
