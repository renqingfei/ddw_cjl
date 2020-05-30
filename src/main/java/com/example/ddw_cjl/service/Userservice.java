package com.example.ddw_cjl.service;

import com.example.ddw_cjl.dao.Userdao;
import com.example.ddw_cjl.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.util.List;

@Service
public class Userservice {
    @Autowired
    private Userdao userdao;
    public int add(User user){
            user.setStatus("正常");
            user.setCreate_date(new Date(0));
            int add = userdao.add(user);
            return add;
    }
    public User login(String email){
        User login = userdao.login(email);
        return login;
    }
    public List<User> QueryAll(){
        List<User> users = userdao.QueryAll();
        return users;
    }
    public void updateuser(User user){
        User user1 = userdao.selectOneUser(user.getId());
        if(user1.getStatus().equals("正常")) {
            user.setStatus("冻结");
            int updateuser = userdao.updateuser(user);
        }else {
            user.setStatus("正常");
            int updateuser = userdao.updateuser(user);

        }
    }
}
