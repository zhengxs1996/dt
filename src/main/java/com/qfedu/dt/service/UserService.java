package com.qfedu.dt.service;

import com.qfedu.dt.entity.User;
import com.qfedu.dt.vo.UserList;

import java.util.List;

public interface UserService {
    public User findRolesByName(String username);

    public List<UserList> findRoleAll();

    public String findByRolesId(int uid);

    public User findByUserName (String username);

    public List<Integer> findByRolesIdByUserId(Integer uid);

    public UserList findRoleId(int uid);

    public int addROle(Integer uid);

    public int deleteRole(Integer uid);

}
