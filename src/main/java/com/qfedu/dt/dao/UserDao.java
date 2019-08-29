package com.qfedu.dt.dao;

import com.qfedu.dt.entity.User;

import java.util.List;

public interface UserDao {
    public User findByName(String username);

    // 根据登陆用户的用户名获取用户角色信息
    public List<String> findRolesByName(String username);

    // 根据登陆用户的用户名获取权限信息
    public List<String> findPermsByName(String username);
}
