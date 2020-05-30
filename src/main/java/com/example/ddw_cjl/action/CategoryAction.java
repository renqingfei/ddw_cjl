package com.example.ddw_cjl.action;

import com.example.ddw_cjl.entity.Category;
import com.example.ddw_cjl.service.Categoryservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryAction {
    @Autowired
    private Categoryservice categoryservice;
    @RequestMapping("/selectAll")
    public String selectAll(HttpServletRequest request){
        List<Category> categories = categoryservice.selectAll();
        request.setAttribute("category",categories);
        return "back/category/show";
    }
    @RequestMapping("/addOne")
    public String addOne(Category category){
        int i = categoryservice.addOne(category);
        return "redirect:/category/selectAll";
    }
    @RequestMapping("/selectAllFirst")
    public String selectAllFirst(HttpServletRequest request){
        List<Category> categories = categoryservice.selectAllFirst();
        request.setAttribute("cate",categories);
        return "back/category/add-second";
    }
    @RequestMapping("/addtwo")
    public String addtwo(Category category){
        int addtwo = categoryservice.addtwo(category);
        return "redirect:/category/selectAll";
    }
    @RequestMapping("/deleteOne")
    public String deleteOne(String id){
        int i = categoryservice.deleteOne(id);
        return "redirect:/category/selectAll";
    }
    @RequestMapping("/selectAlltwo")
    public String selectAlltwo(HttpSession session){
        List<Category> categories = categoryservice.selectAlltwo();
        session.setAttribute("category",categories);
        return "back/book/add";
    }
}
