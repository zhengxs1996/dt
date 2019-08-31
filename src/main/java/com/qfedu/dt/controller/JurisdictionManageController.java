package com.qfedu.dt.controller;

import com.qfedu.dt.common.JsonResult;
import com.qfedu.dt.entity.Permission;
import com.qfedu.dt.entity.Role;
import com.qfedu.dt.service.JurisdictionManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: dt
 * @description:
 * @author: sjm
 * @create: 2019-08-29 16:23
 **/
@Controller
@RequestMapping("/jurisdiction")
public class JurisdictionManageController {
    @Autowired
    private JurisdictionManageService jurisdictionManageService;

    @RequestMapping("/page.do")
    public String page(HttpServletResponse response){
        return "after/jurisdictionManage";
    }

    @RequestMapping("/jumpModify.do")
    public String JumpModifyJurisdiction(Integer rid, Model model){
        model.addAttribute("rid",rid);
        return "after/jurisdictionManage-modify";
    }

    @ResponseBody
    @RequestMapping("/findAll.do")
    public JsonResult findAllPermission(){
        List<Permission> all = jurisdictionManageService.findAll();
        return new JsonResult(0,all);
    }

    @ResponseBody
    @RequestMapping("/findAllRole.do")
    public Map<String, Object> findAllRole(){
        List<Role> allRole = jurisdictionManageService.findAllRole();
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("data",allRole);
        return map;
    }

    @ResponseBody
    @RequestMapping("/getChecked.do")
    public JsonResult getChecked(Integer rid){
        Integer[] checked = jurisdictionManageService.getChecked(rid);
        return new JsonResult(0,checked);
    }


}
