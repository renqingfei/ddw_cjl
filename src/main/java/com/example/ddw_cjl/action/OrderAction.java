package com.example.ddw_cjl.action;

import com.example.ddw_cjl.entity.Address;
import com.example.ddw_cjl.entity.Item;
import com.example.ddw_cjl.entity.Order;
import com.example.ddw_cjl.entity.User;
import com.example.ddw_cjl.service.Itemservice;
import com.example.ddw_cjl.service.Orderservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderAction {
    @Autowired
    private Orderservice orderservice;
    @Autowired
    private Itemservice itemservice;
    @RequestMapping("/addorder")
    public String addorder(Address address, HttpSession session,String message){
        User login = (User) session.getAttribute("login");
        address.setUser_id(login.getId()+"");
        try {
            orderservice.Addorder(address);
        } catch (RuntimeException e) {
             message=e.getMessage();
            return "front/order/address_form";
        }
        return "front/order/order_ok";
    }
    @RequestMapping("/queryAll")
    public String queryAll(HttpServletRequest request){
        List<Order> orders = orderservice.queryAll();
        request.setAttribute("orders", orders);
        return "back/order/show";
    }
    @RequestMapping("/selectOne")
    public String selectOne(String id,HttpServletRequest request){
        Order order = orderservice.selectOne(id);
        request.setAttribute("order", order);
        List<Item> items = itemservice.selectItems(id);
        request.setAttribute("items", items);
        return "back/order/detail";
    }
}
