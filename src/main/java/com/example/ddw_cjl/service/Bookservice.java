package com.example.ddw_cjl.service;

import com.example.ddw_cjl.dao.Bookdao;
import com.example.ddw_cjl.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class Bookservice {
    @Autowired
    private Bookdao bookdao;
    public List<Book> selectAll(){
        List<Book> books = bookdao.selectAll();
        return books;
    }
    public int addbook(Book book){
        book.setSale(0);
        book.setCreate_date(new Date(0));
        int addbook = bookdao.addbook(book);
        return addbook;
    }
    public Book selectOne(String id){
        Book book = bookdao.selectOne(id);
        return book;
    }
    public int updatebook(Book book){
        int updatebook = bookdao.updatebook(book);
        return updatebook;
    }
    public int deletebook(String id){
        int deletebook = bookdao.deletebook(id);
        return deletebook;
    }
    public List<Book> selectByKey(String key,String content){
        List<Book> books = bookdao.selectByKey(key, content);
        return books;
    }
    public List<Book> selectBySale(){
        List<Book> books = bookdao.selectBySale();
        return books;
    }
    public List<Book> selectAlltwo(){
        List<Book> books = bookdao.selectAll();
        //获取两个随机数作为下标
        Integer a = new Random().nextInt(books.size());
        Integer b = new Random().nextInt(books.size());
        while(true){
            if(a==b){
                b = new Random().nextInt(books.size());
            }else{
                break;
            }
        }
        //新建集合，通过下标获取数据放入新集合中
        List<Book> book = new ArrayList<Book>();
        book.add(books.get(a));
        book.add(books.get(b));
        return book;
    }
    public List<Book> selecttime(){
        List<Book> selecttime = bookdao.selecttime();
        return selecttime;
    }
    public List<Book> selectsale(){
        List<Book> selectsale = bookdao.selectsale();
        return selectsale;
    }

    public List<Book> selectAllByFid(String fid) {
        return bookdao.selectAllByFid(fid);
    }

    public List<Book> selectAllBySid(String sid) {
        return bookdao.selectAllBySid(sid);
    }
}
