package com.example.ddw_cjl.service;

import com.example.ddw_cjl.dao.Admindao;
import com.example.ddw_cjl.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Adminservice {
    @Autowired
    private Admindao admindao;
    public Admin login(String username,String password){
        Admin login = admindao.login(username, password);
        return login;
    }
}
