package com.qfedu.dt.service.impl;

import com.qfedu.dt.dao.StudentLoginDao;
import com.qfedu.dt.service.StudentLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentLoginServiceImpl implements StudentLoginService {

    @Autowired(required = false)
    private StudentLoginDao studentLoginDao;

    @Override
    public void studentLogin(String name, String password) {
        String studentPassword = studentLoginDao.findStudentPassword(name);
        if (studentPassword == null) {
            throw new RuntimeException("账号不存在");
        } else if (!studentPassword.equals(password)) {
            throw new RuntimeException("账号或者密码有误");
        }
    }

    @Override
    public Integer findsid(String name) {
        return studentLoginDao.findsid(name);
    }
}
