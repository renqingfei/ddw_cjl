package com.example.ddw_cjl.service;

import com.example.ddw_cjl.dao.Bookdao;
import com.example.ddw_cjl.entity.Book;
import com.example.ddw_cjl.entity.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
public class CartService {
    @Autowired
    private Bookdao bookdao;
    public  void addCart(String id) {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        Book book = bookdao.selectOne(id);

        //从session中获取购物车
        Map<String, CartItem> map = (Map<String, CartItem>) session.getAttribute("cart");
        double save = 0.0;
        double total = 0.0;
        //第一次判断，判断有无购物车
        if (map == null) {//没有购物车
            map = new HashMap<String, CartItem>();
            //购物车中没有
            CartItem item = new CartItem();
            item.setBook(book);
            //第一次添加初始值为1
            item.setCount(1);
            //添加map集合
            map.put(id, item);
            save = book.getPrice() - book.getDprice();//节省的钱
            total = book.getDprice();

        } else {
            //判断是否是第一次购买该类商品
            save = (Double) session.getAttribute("save");
            total = (Double) session.getAttribute("total");
            if (map.containsKey(id)) {
                //说明 购物车已经有这个商品了
                CartItem item = map.get(id);
                //数量+1
                item.setCount((item.getCount() + 1));
                //添加map集合
                map.put(id, item);
            } else {
                //购物车中没有这个商品
                CartItem item = new CartItem();
                item.setBook(book);
                //第一次添加初始值为1
                item.setCount(1);
                //添加map集合
                map.put(id, item);
            }
            save = save + book.getPrice() - book.getDprice();//节省的钱
            total = total + book.getDprice();//总价
        }
        session.setAttribute("cart", map);
        session.setAttribute("save", save);
        session.setAttribute("total", total);
    }
    public void updateCart(Integer count, String id) {
        // 获取session
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        Book book = bookdao.selectOne(id);
        //
        double save = (Double) session.getAttribute("save");
        double total = (Double) session.getAttribute("total");
        // 从session中获取购物车
        Map<String, CartItem> map = (Map<String, CartItem>) session.getAttribute("cart");
        CartItem item = map.get(id);
        Integer oldcount = item.getCount();
        save = save - (book.getPrice() - book.getDprice()) * oldcount;
        total = total - book.getDprice() * oldcount;
        item.setCount(count);
        //添加map集合
        map.put(id, item);
        save = save + (book.getPrice() - book.getDprice()) * count;
        total = total + book.getDprice() * count;
        session.setAttribute("cart", map);
        session.setAttribute("save", save);
        session.setAttribute("total", total);
    }

    public void deletecart(String id) {
        // 获取session
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        double save = (Double) session.getAttribute("save");
        double total = (Double) session.getAttribute("total");
        // 从session中获取购物车
        Map<String, CartItem> map = (Map<String, CartItem>) session.getAttribute("cart");
        Book book = bookdao.selectOne(id);
        CartItem item = map.get(id);
        Integer oldcount = item.getCount();
        map.remove(id);
        save = save - (book.getPrice() - book.getDprice()) * oldcount;
        total = total - book.getDprice() * oldcount;
        //说明购物车为空
        if (map.size() == 0) {
            session.removeAttribute("cart");
        } else {
            session.setAttribute("cart", map);
        }
        session.setAttribute("save", save);
        session.setAttribute("total", total);
    }

}
