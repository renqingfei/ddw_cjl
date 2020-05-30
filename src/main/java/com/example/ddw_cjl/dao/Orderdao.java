package com.example.ddw_cjl.dao;

import com.example.ddw_cjl.entity.Order;
import org.apache.ibatis.annotations.Insert;

public interface Orderdao {
    //前台添加订单
    @Insert(" insert into order values(#{id},#{order_no},#{total},#{status},#{create_date},#{address_id},#{user_id})")
    public int addOrder(Order order);
}
