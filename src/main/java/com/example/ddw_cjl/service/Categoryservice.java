package com.example.ddw_cjl.service;

import com.example.ddw_cjl.dao.Categorydao;
import com.example.ddw_cjl.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class Categoryservice {
    @Autowired
    private Categorydao categorydao;
    public List<Category> selectAll(){
        List<Category> categories = categorydao.selectAll();
        return categories;
    }
    public int addOne(Category category){
        category.setId(UUID.randomUUID().toString());
        category.setLevels("1");
        int i = categorydao.addOne(category);
        return i;
    }
    public List<Category> selectAllFirst(){
        List<Category> categories = categorydao.selectAllFirst();
        return categories;
    }
    public int addtwo(Category category){
        category.setId(UUID.randomUUID().toString());
        category.setLevels("2");
        int addtwo = categorydao.addtwo(category);
        return addtwo;
    }
    public int deleteOne(String id){
        List<Category> selecttwo = categorydao.selecttwo(id);
        if(selecttwo.size()==0){
            int i = categorydao.deleteOne(id);
            return i;
        }
        return 0;
    }
    public List<Category> selectAlltwo(){
        List<Category> categories = categorydao.selectAlltwo();
        return categories;
    }
    public List<Category> selectFirsts(){
        List<Category> categories = categorydao.selectFirsts();
        for(Category one:categories){
            List<Category> category = categorydao.selectOneFirst(one.getId());
            one.setSons(category);
        }
        return categories;
    }

}
