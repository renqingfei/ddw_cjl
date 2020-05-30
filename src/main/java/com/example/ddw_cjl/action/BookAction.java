package com.example.ddw_cjl.action;

import com.example.ddw_cjl.entity.Book;
import com.example.ddw_cjl.entity.Category;
import com.example.ddw_cjl.service.Bookservice;
import com.example.ddw_cjl.service.Categoryservice;
import com.example.ddw_cjl.util.UpAndDown;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookAction {
    @Autowired
    private Bookservice bookservice;
    @Autowired
    private Categoryservice categoryservice;
    @RequestMapping("/selectAll")
    public String selectAll(HttpServletRequest request){
        List<Book> books = bookservice.selectAll();
        request.setAttribute("book",books);
        return "back/book/show";
    }
    @RequestMapping("/addbook")
    public String addbook(Book book, MultipartFile myFile,HttpServletRequest request){
        String upload = UpAndDown.upload(myFile, request);
        book.setCover(upload);
        int addbook = bookservice.addbook(book);
        return "redirect:/book/selectAll";
    }
    @RequestMapping("/selectOne")
    public String selectOne(String id,HttpServletRequest request){
        Book book = bookservice.selectOne(id);
        request.setAttribute("book",book);
        return "back/book/update";
    }
    @RequestMapping("/updatebook")
    public String updatebook(Book book, MultipartFile myFile,HttpServletRequest request) {
        String upload = UpAndDown.upload(myFile, request);
        if(!"".equals(upload)){
            book.setCover(upload);
        }
        int updatebook = bookservice.updatebook(book);
        return "redirect:/book/selectAll";
    }
    @RequestMapping("/deletebook")
    public String deletebook(String id){
        int deletebook = bookservice.deletebook(id);
        return "redirect:/book/selectAll";
    }
    @RequestMapping("/selectByKey")
    public String selectByKey(String key,String content,HttpServletRequest request){
        List<Book> books = bookservice.selectByKey(key, content);
        request.setAttribute("book",books);
        return "back/book/show";
    }
    @RequestMapping("/selectFirst")
    public String selectFirst(HttpServletRequest request){
        List<Category> categories = categoryservice.selectFirsts();
        request.setAttribute("cateone",categories);
        List<Book> books1 = bookservice.selectAlltwo();
        request.setAttribute("booktwo",books1);
        List<Book> books = bookservice.selectBySale();
        request.setAttribute("booksale",books);
        List<Book> selecttime = bookservice.selecttime();
        request.setAttribute("booktime",selecttime);
        List<Book> selectsale = bookservice.selectsale();
        request.setAttribute("timesale",selectsale);
        return "front/main/main";
    }
    @RequestMapping("/selectOneBook")
    public String selectOneBook(String id,HttpServletRequest request){
        Book book = bookservice.selectOne(id);
        request.setAttribute("bookone",book);
        return "front/main/book_detail";
    }

    @RequestMapping("/selectSecond")
    public String selectSecond(String fid,String sid,HttpServletRequest request,@RequestParam(value = "pageNum",defaultValue = "1") int pageNum){
        //查询一级类目下所有的二级类目
        List<Category> categories = categoryservice.selectFirsts();
        Category category1 = new Category();
        for (Category category : categories) {
            if(category.getId().equals(fid)){
                BeanUtils.copyProperties(category,category1);
            }
        }
        request.setAttribute("cateone",category1);
        request.setAttribute("sid",sid);
        request.setAttribute("fid",fid);
        PageHelper.startPage(pageNum,3);
        List<Book> books = Collections.emptyList();
        if(StringUtils.isEmpty(sid)){
            //查询全部的书
            books = bookservice.selectAllByFid(fid);
        }else {
            //查询二级的书
            books = bookservice.selectAllBySid(sid);
        }
        //得到分页的结果对象
        PageInfo<Book> bookPageInfo = new PageInfo<>(books);
        request.setAttribute("bookss",bookPageInfo.getList());
        request.setAttribute("total",bookPageInfo.getTotal()/3+1);
        request.setAttribute("pageNum",bookPageInfo.getPageNum());
        return "front/main/book_list";
    }
}
