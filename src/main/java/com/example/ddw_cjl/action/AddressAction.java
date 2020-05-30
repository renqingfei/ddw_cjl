package com.example.ddw_cjl.action;

import com.example.ddw_cjl.entity.Address;
import com.example.ddw_cjl.service.Addressservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/address")
public class AddressAction {
    @Autowired
    private Addressservice addressservice;
    @RequestMapping("/selectAddress")
    public String selectAddress(HttpServletRequest request) {
        List<Address> addresses = addressservice.selectAll();
        request.getSession().setAttribute("list",addresses);
        return "front/order/address_form";
    }
    @RequestMapping("/getAddressById")
    public String getAddressById(Integer id,HttpServletRequest request){
        Address address = addressservice.selectOne(id);
        request.setAttribute("address",address);
        return "front/order/address_form";
    }
}
