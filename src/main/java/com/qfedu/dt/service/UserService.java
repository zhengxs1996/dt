package com.qfedu.dt.service;

import com.qfedu.dt.entity.User;

public interface UserService {
    public User findByUserName(String username);
}
