package com.qfedu.dt.controller;

import com.qfedu.dt.common.JsonResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "after/login";
    }

    @RequestMapping("/toList")
    public String toUserList(){
        return "after/backstage";
    }

    @RequestMapping("/login")
    @ResponseBody
    public JsonResult login(String username, String password){
        //根据用户输入的用户名和密码信息创建token对象，用于和合法认证信息进行比较
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        //获取Subject主题对象
        Subject subject= SecurityUtils.getSubject();

        try {
            subject.login(token);
            return new JsonResult(1,null);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return new JsonResult(0,null);
        }

    }
}
