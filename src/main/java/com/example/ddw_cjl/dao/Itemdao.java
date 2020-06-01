package com.example.ddw_cjl.dao;
import com.example.ddw_cjl.entity.Item;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Itemdao {
    @Insert(" insert into  item values(#{id},#{book_id},#{order_id},#{count},#{create_date})")
    public void addOneItem(Item item);
    @Select("select * from item  i left join book b on i.book_id=b.id where i.order_id=#{id} ")
    public List<Item> selectItems(String id);
}
