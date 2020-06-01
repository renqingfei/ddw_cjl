package com.example.ddw_cjl.service;

import com.example.ddw_cjl.dao.Itemdao;
import com.example.ddw_cjl.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Itemservice {
    @Autowired
    private Itemdao itemdao;
    public List<Item> selectItems(String id){
        List<Item> items = itemdao.selectItems(id);
        return items;
    }
}
