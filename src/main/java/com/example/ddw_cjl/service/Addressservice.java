package com.example.ddw_cjl.service;

import com.example.ddw_cjl.dao.Addressdao;
import com.example.ddw_cjl.entity.Address;
import com.example.ddw_cjl.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
@Service
public class Addressservice {
    @Autowired
    private Addressdao addressdao;
    public List<Address> selectAll(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        User login = (User)session.getAttribute("login");
        if(login!=null){
            List<Address> addresses = addressdao.selectAll(login.getId());
            return addresses;
        }
        return null;
    }
    public Address selectOne(int id){
        Address address = addressdao.selectOne(id);
        return address;
    }
}
