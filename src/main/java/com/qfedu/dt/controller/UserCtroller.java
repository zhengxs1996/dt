package com.qfedu.dt.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.dt.common.JsonResult;
import com.qfedu.dt.entity.Role;
import com.qfedu.dt.entity.User;
import com.qfedu.dt.service.UserService;
import com.qfedu.dt.untils.StrUtil;
import com.qfedu.dt.vo.UserList;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.relation.RoleList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserCtroller {

    @Autowired
    private UserService userService;

    public JsonResult findRolesByName(String username) {
        User user=userService.findRolesByName(username);
        return new JsonResult();
    }

    /**
     * 展示登陆的信息,角色,如果是管理员展示所有的信息,如果是单个教师信息展示单个的信息不给与增加删除角色的权限
     * @param page 开启分页
     * @param limit
     * @param session
     * @return
     */
    @RequestMapping("/RoleList.do")
    @ResponseBody
    public Map<String,Object> RoleList(Integer page, Integer limit, HttpSession session) {
        User user =(User) session.getAttribute(StrUtil.LONGIN_USER);
        List<Integer> rids=(List<Integer>) session.getAttribute("rids");
        if (rids.size() == 2) {
            PageHelper.startPage(page,limit);
            List<UserList> list=userService.findRoleAll();
            for (UserList u : list) {
                if (u.getRole().size() > 1) {
                    u.setRoleName("管理員/老師");
                } else {
                    List<Role> role=u.getRole();
                    for (Role role1 : role) {
                        u.setRoleName(role1.getRolename());
                    }
                }
            }
            long total = ((Page) list).getTotal();
            Map<String,Object> map = new HashMap<>();
            map.put("code",0);
            map.put("msg","");
            map.put("count",total);
            map.put("data",list);
            return map;
        } else {
            int i=rids.indexOf(0);
            if (i == 1) {
                PageHelper.startPage(page,limit);
                List<UserList> list=userService.findRoleAll();
                long total = ((Page) list).getTotal();
                Map<String,Object> map = new HashMap<>();
                map.put("code",0);
                map.put("msg","");
                map.put("count",total);
                map.put("data",list);
                return map;
            } else {
                PageHelper.startPage(page,limit);
                UserList userList=userService.findRoleId(user.getUid());
                long total = 1L;
                Map<String,Object> map = new HashMap<>();
                map.put("code",0);
                map.put("msg","");
                map.put("count",total);
                map.put("data",userList);
                return map;
            }
        }
    }

    @RequestMapping("/addRoles.do")
    public String add(){
        return "after/addRole";
    }

    /**
     * 添加教师成为管理员,管理员权限
     * @param uid 选中的教师id
     * @return
     */
    @RequestMapping("/addRole.do")
    @ResponseBody
    public JsonResult addRoleToMan(HttpSession session,Integer uid) {
        List<Integer> rids=(List<Integer>) session.getAttribute("rids");
        if (rids.size() == 2) {
            userService.addROle(uid);
            return new JsonResult(0, null);
        } else  {
            return new JsonResult(1,"没有添加的权限");
        }
    }

    @RequestMapping("/roleManage")
    public String selectQuestions() {
        return "after/roleManagement";
    }
    /**
     * 删除管理员成为教师,管理员权限
     *
     * @param uid 选中的管理员id
     * @return
     */
    @RequestMapping("/deleteRole.do")
    @ResponseBody
    public JsonResult deleteRole(HttpSession session, Integer uid) {
        List<Integer> rids=(List<Integer>) session.getAttribute("rids");
        if (rids.size() == 2) {
            userService.deleteRole(uid);
            return new JsonResult(0, null);
        } else {
            return new JsonResult(1, null);
        }
    }

}
