package com.qfedu.dt.service.impl;

import com.qfedu.dt.dao.UserDao;
import com.qfedu.dt.entity.User;
import com.qfedu.dt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserDao userDao;

    @Override
    public User findByUserName(String username) {
        return userDao.findByName(username);
    }
}
