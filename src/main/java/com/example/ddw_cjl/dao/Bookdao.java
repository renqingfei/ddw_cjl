package com.example.ddw_cjl.dao;

import com.example.ddw_cjl.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface Bookdao {
    @Select("select * from book")
    public List<Book> selectAll();
    @Insert(" insert into book(id,name,author,cover,press,press_date,edition,print_date,impression,isbn,word_num,page_num,sizes,paper,pack,price,dprice,create_date,editor_recommend,content_abstract,author_abstract,director,media_commentary,category_id,sale,stock) values(#{id},#{name},#{author},#{cover},#{press},#{press_date},#{edition},#{print_date},#{impression},#{isbn},#{word_num},#{page_num},#{sizes},#{paper},#{pack},#{price},#{dprice},#{create_date},#{editor_recommend},#{content_abstract},#{author_abstract},#{director},#{media_commentary},#{category_id},#{sale},#{stock})")
    public int addbook(Book book);
    @Select("select * from book where id=#{id}")
    public Book selectOne(String id);
    //修改
    @Update("update book set name=#{name},author=#{author},cover=#{cover},press=#{press},press_date=#{press_date},edition=#{edition},print_date=#{print_date},impression=#{impression},isbn=#{isbn},word_num=#{word_num},page_num=#{page_num},sizes=#{sizes},paper=#{paper},pack=#{pack},price=#{price},dprice=#{dprice},editor_recommend=#{editor_recommend},content_abstract=#{content_abstract},author_abstract=#{author_abstract},director=#{director},media_commentary=#{media_commentary},category_id=#{category_id},sale=#{sale},stock=#{stock} where id=#{id}")
    public int updatebook(Book book);
    //搜索
    @Select("select * from book where ${key} like concat('%',#{content},'%')")
    public List<Book> selectByKey(@Param("key")String key, @Param("content")String content);
    //删除
    @Delete("delete from book where id=#{id}")
    public int deletebook(String id);
    //热卖图书
    @Select("select * from book  order by sale desc  limit 0,8")
    public List<Book> selectBySale();
    //最新上架时间
    @Select("select * from book order by create_date desc limit 0,8")
    public List<Book> selecttime();
    //新书热卖
    @Select("select * from book order by create_date desc,sale desc limit 0,8")
    public List<Book> selectsale();

    @Select("select * from book where category_id in(select id from gategory where parentid=#{fid})")
    List<Book> selectAllByFid(String fid);

    @Select("select * from book where category_id = #{sid}")
    List<Book> selectAllBySid(String sid);
}
