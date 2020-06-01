package com.example.ddw_cjl.dao;

import com.example.ddw_cjl.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Orderdao {
    //前台添加订单
    @Insert(" INSERT INTO `dangdang`.`order` ( `id`, `order_no`, `total`, `status`, `create_date`, `address_id`, `user_id` ) values(#{id},#{order_no},#{total},#{status},#{create_date},#{address_id},#{user_id})")
    public int addOrder(Order order);
    //后台查所有订单
    @Select("select * from `order` o LEFT JOIN address a on o.address_id = a.id")
    public List<Order> queryAll();
    //
    @Select("select * from `order` where id=#{id}")
    public Order selectOne(String id);
}
