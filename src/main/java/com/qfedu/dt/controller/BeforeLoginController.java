package com.qfedu.dt.controller;

import com.qfedu.dt.common.JsonResult;
import com.qfedu.dt.service.StudentLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@CrossOrigin
@Controller
@RequestMapping("/before")
public class BeforeLoginController {

    @Autowired
    private StudentLoginService studentLoginService;

    @RequestMapping("/studentLogin")
    @ResponseBody
    public JsonResult studentLogin(String name, String password) {
        HashMap<Object, Object> map = new HashMap<>();

        try {
            studentLoginService.studentLogin(name, password);
            Integer sid = studentLoginService.findsid(name);
            map.put("name", name);
            map.put("sid", sid);
            map.put("password", password);
            map.put("info", "登录成功");

            return new JsonResult(1, map);
        } catch (Exception e) {
            return new JsonResult(0, e.getMessage());
        }


    }
}
