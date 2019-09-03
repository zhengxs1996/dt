package com.qfedu.dt.dao;

import com.qfedu.dt.entity.User;
import com.qfedu.dt.vo.UserList;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.List;

public interface UserDao {
    public User findByName(String username);

    public List<String> findRolesByName(String username);

    // 根据登陆用户的用户名获取权限信息
    public List<String> findPermsByName(String username);

    //管理员权限的用户名获取登陆的角色信息和用户名和密码
    public List<UserList> findRolesAll();

    public String findRolesById(int uid);

    public UserList findRoleId(int uid);


    //通过用户ID查询角色ID
    public List<Integer> findRolesIdByUserId(Integer uid);

    public int addRole(Integer uid);

    public int deleteRole(Integer uid);


}
