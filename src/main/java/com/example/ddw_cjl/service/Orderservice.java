package com.example.ddw_cjl.service;

import com.example.ddw_cjl.dao.Addressdao;
import com.example.ddw_cjl.dao.Bookdao;
import com.example.ddw_cjl.dao.Itemdao;
import com.example.ddw_cjl.dao.Orderdao;
import com.example.ddw_cjl.entity.*;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class Orderservice {
    @Autowired
    private Orderdao orderdao;
    @Autowired
    private Bookdao bookdao;
    @Autowired
    private Itemdao itemdao;
    @Autowired
    private Addressdao addressdao;
    public void Addorder(Address address){
        // 获取session
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        double total = (Double) session.getAttribute("total");
       Map<String, CartItem> map=(Map<String, CartItem>) session.getAttribute("cart");
       //判断地址栏是否为空
      if("".equals(address.getName())||"".equals(address.getLocal())||"".equals(address.getPhone())||"".equals(address.getZip_code())){
          throw new RuntimeException("地址栏不能为空");
      }
            User user=(User) session.getAttribute("login");
      //地址栏为空
            if(address.getId()==0||"".equals(address.getId())){
                address.setUser_id(user.getId()+"");
                addressdao.addOneAddress(address);
            }else{
                //地址栏不为空
                Address selectOne = addressdao.selectOne(address.getId());
                //判断地址是否发生改变
                if(!selectOne.equals(address)){
                    addressdao.updateone(address);
                }
            }
            Order ord=new Order();
            Date date=new Date();
            ord.setId(UUID.randomUUID().toString());
            ord.setOrder_no(date.getTime());
            ord.setUser_id(user.getId());
            ord.setStatus("未付款");
            ord.setTotal(total);
            ord.setAddress_id(address.getId());
            ord.setCreate_date(date);
            orderdao.addOrder(ord);
            Set<String> set=map.keySet();
            for(String id:set){
                CartItem cart=map.get(id);
                Item items=new Item();
                items.setId(UUID.randomUUID().toString());
                items.setBook_id(Integer.parseInt(id));
                items.setCount(cart.getCount());
                items.setCreate_date(date);
                items.setOrder_id(ord.getId());
                itemdao.addOneItem(items);
                Book book2 = cart.getBook();
                book2.setSale(book2.getSale()+cart.getCount());
                book2.setStock(book2.getStock()-cart.getCount());
                bookdao.updatebook(book2);
            }
            session.removeAttribute("cart");
            session.setAttribute("orderno", ord.getOrder_no());
    }
    public List<Order> queryAll(){
        List<Order> orders = orderdao.queryAll();
        return orders;
    }
    public Order selectOne(String id){
        Order order = orderdao.selectOne(id);
        return order;
    }
}
