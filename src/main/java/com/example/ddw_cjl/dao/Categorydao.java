package com.example.ddw_cjl.dao;

import com.example.ddw_cjl.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Categorydao {
    @Select("select g.id,g.name,g2.name parentid,g.levels from gategory g LEFT JOIN gategory g2 on g.parentid = g2.id order by g.levels")
    public List<Category> selectAll();
    //添加一级类别
    @Insert("insert into gategory(id,name,levels) values(#{id},#{name},#{levels})")
    public int addOne(Category category);
    //查询所有一级类别
    @Select("select * from gategory where levels=1")
    public List<Category> selectAllFirst();
    //添加二级类别
    @Insert("insert into gategory(id,name,parentid,levels) values(#{id},#{name},#{parentid},#{levels})")
    public int addtwo(Category category);
    //查询一级类别下有没有二级类别
    @Select("select * from gategory where parentid=#{id}")
    public List<Category> selecttwo(String id);
    //删除类别
    @Delete("delete from gategory where id=#{id}")
    public int deleteOne(String id);
    //查询所有二级类别
    @Select("select * from gategory where levels=2 ")
    public List<Category> selectAlltwo();
    //1前台首页的分页浏览
    @Select("select * from gategory where levels=1")
    public List<Category> selectFirsts();
    @Select("select * from gategory where parentid=#{id}")
    public List<Category> selectOneFirst(String id);
}
