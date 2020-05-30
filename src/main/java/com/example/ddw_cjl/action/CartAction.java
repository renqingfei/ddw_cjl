package com.example.ddw_cjl.action;

import com.example.ddw_cjl.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class CartAction {
    @Autowired
    private CartService cartService;
    @RequestMapping("/addCart")
    public  String addCart(String id) {
        cartService.addCart(id);
        return "front/cart/cart_list";
    }
    @RequestMapping("/updateCart")
    //变更
    public String updateCart(Integer count, String id){
        cartService.updateCart(count, id);
        return "front/cart/cart_list";
     }
    @RequestMapping("/deletecart")
    //删除
    public String deletecart(String id){
        cartService.deletecart(id);
        return "front/cart/cart_list";
    }
}

