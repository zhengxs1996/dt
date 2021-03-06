package com.qfedu.dt.controller;

import com.qfedu.dt.entity.User;
import com.qfedu.dt.service.MenuService;
import com.qfedu.dt.untils.StrUtil;
import com.qfedu.dt.vo.MenuList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/menu.do")
    @ResponseBody
    public List<MenuList> menuList(HttpSession session) {
        User loginUser = (User) session.getAttribute(StrUtil.LONGIN_USER);
        Integer uid = loginUser.getUid();
        return menuService.menuList(uid);
    }
}
