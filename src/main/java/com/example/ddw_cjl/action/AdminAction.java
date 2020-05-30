package com.example.ddw_cjl.action;

import com.example.ddw_cjl.entity.Admin;
import com.example.ddw_cjl.service.Adminservice;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminAction {
    @Autowired
    private Adminservice adminservice;
    @RequestMapping("/login")
    public String login(String username,String password,HttpSession session,String yanzhengma){
        Admin login = adminservice.login(username, password);
        if(login==null){
            session.setAttribute("message","用户名密码错误！");
            return "back/login";
        }else {
            //判断验证码是否输入一致
            boolean bool = checkVerify(yanzhengma, session);
            if(bool){
                session.setAttribute("login",login);
                return "back/main/main";
            }
            session.setAttribute("message","验证码错误！");
            return "back/login";
        }
    }


    /**
     * 校验验证码
     */
    private boolean checkVerify(String verifyInput, HttpSession session) {
        try{
            //从session中获取随机数
            String inputStr = verifyInput;
            String random = (String) session.getAttribute("RANDOMVALIDATECODEKEY");
            if (random == null) {
                return false;
            }
            if (random.equals(inputStr)) {
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }
}
