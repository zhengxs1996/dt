package com.qfedu.dt.service;

public interface StudentLoginService {
    /**
     * 验证学生登录信息
     * @param name
     * @param password
     */
    public void studentLogin(String name, String password);
}
