package com.qfedu.dt.service.impl;

import com.qfedu.dt.dao.UserDao;
import com.qfedu.dt.entity.User;
import com.qfedu.dt.service.UserService;
import com.qfedu.dt.vo.UserList;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired(required=false)
    private UserDao userDao;

    @Override
    public User findByUserName(String username) {
        return userDao.findByName(username);
    }

    @Override
    public List<UserList> findRoleAll() {
        return userDao.findRolesAll();
    }

    @Override
    public String findByRolesId(int uid) {
        return userDao.findRolesById(uid);
    }


    @Override
    public List<Integer> findByRolesIdByUserId(Integer uid) {
        return userDao.findRolesIdByUserId(uid);
    }

    @Override
    public UserList findRoleId(int uid) {
        return userDao.findRoleId(uid);
    }

    @Override
    public int addROle(Integer uid) {
        return userDao.addRole(uid);
    }

    @Override
    public int deleteRole(Integer uid) {
        return userDao.deleteRole(uid);
    }

    @Override
    public User findRolesByName(String username) {
        return userDao.findByName(username);
    }


}
