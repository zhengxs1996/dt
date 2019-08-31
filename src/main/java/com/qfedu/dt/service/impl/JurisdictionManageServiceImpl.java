package com.qfedu.dt.service.impl;

import com.qfedu.dt.dao.JurisdictionManageDao;
import com.qfedu.dt.entity.Permission;
import com.qfedu.dt.entity.Role;
import com.qfedu.dt.service.JurisdictionManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: dt
 * @description:
 * @author: sjm
 * @create: 2019-08-30 16:04
 **/
@Service
public class JurisdictionManageServiceImpl implements JurisdictionManageService {
    @Autowired(required = false)
    private JurisdictionManageDao jurisdictionManageDao;
    @Override
    public List<Permission> findAll() {
        return jurisdictionManageDao.findAll();
    }

    public List<Role> findAllRole(){
        return jurisdictionManageDao.findAllRole();
    }

    @Override
    public Integer[] getChecked(Integer rid) {
        return jurisdictionManageDao.getChecked(rid);
    }
}
