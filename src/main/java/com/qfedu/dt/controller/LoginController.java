package com.qfedu.dt.controller;

import com.qfedu.dt.common.JsonResult;
import com.qfedu.dt.entity.User;
import com.qfedu.dt.service.UserService;
import com.qfedu.dt.untils.StrUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "after/login";
    }

    @RequestMapping("/toList")
    public String toUserList() {
        return "after/backstage";
    }

    @RequestMapping("/login")
    @ResponseBody
    public JsonResult login(String username, String password, HttpSession session) {

        //根据用户输入的用户名和密码信息创建token对象，用于和合法认证信息进行比较
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //获取Subject主题对象
        Subject subject = SecurityUtils.getSubject();

        User user = userService.findByUserName(username);

        List<Integer> rids=userService.findByRolesIdByUserId(user.getUid());

        try {
            subject.login(token);
            session.setAttribute(StrUtil.LONGIN_USER, user);
            session.setAttribute("rids",rids);
            return new JsonResult(1, null);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return new JsonResult(0, null);
        }

    }
}
