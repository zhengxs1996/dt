package com.qfedu.dt.service;

public interface StudentLoginService {
    /**
     * 验证学生登录信息
     * @param name
     * @param password
     */
    public void studentLogin(String name, String password);

    /**
     * 找到登录学生的sid
     * @param name 学生姓名
     * @return 返回学生id
     */
    public Integer findsid(String name);
}
