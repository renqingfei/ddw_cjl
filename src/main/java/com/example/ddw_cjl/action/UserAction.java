package com.example.ddw_cjl.action;

import com.example.ddw_cjl.entity.User;
import com.example.ddw_cjl.service.Userservice;
import com.example.ddw_cjl.util.RandomValidateCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserAction {
    @Autowired
    private Userservice userservice;
    @RequestMapping("/add")
    public String add(User user,HttpSession session) {
        //验证码
        User login = userservice.login(user.getEmail());
        if (login != null) {
            session.setAttribute("message","该邮箱已被注册");
            return "front/user/register_form";
        } else {
            int add = userservice.add(user);
            session.setAttribute("login",add);
            return "front/user/verify_form";
        }
    }
    @RequestMapping("/login")
    public String login(String email,String password,HttpSession session){
        User login = userservice.login(email);
        session.setAttribute("login",login);
        if(login!=null){
          if(!login.getPassword().equals(password)) {
                session.setAttribute("message","密码错误！");
              return "front/user/login_form";
            }
            return "redirect:/book/selectFirst";
        }else {
            session.setAttribute("message","此人不存在！");
           return "front/user/login_form";
        }
    }
    @RequestMapping("/QueryAll")
    public String QueryAll(HttpServletRequest request){
        List<User> users = userservice.QueryAll();
        request.setAttribute("user",users);
        return "back/user/show";
    }
    @RequestMapping("/updateuser")
    public String updateuser(User user){
        userservice.updateuser(user);
        return "redirect:/QueryAll";
    }
    @RequestMapping("/user/getCode")
    public void  getCode(HttpServletRequest request, HttpServletResponse response){
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 校验验证码
     */
    public boolean checkVerify(@RequestParam String verifyInput, HttpSession session) {
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
