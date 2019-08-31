package com.qfedu.dt.dao;

import com.qfedu.dt.entity.Permission;
import com.qfedu.dt.entity.Role;

import java.util.List;

/**
 * @program: dt
 * @description: 权限管理的dao层
 * @author: sjm
 * @create: 2019-08-29 16:21
 **/
public interface JurisdictionManageDao {
    public List<Permission> findAll();

    public List<Role> findAllRole();

    public Integer[] getChecked(Integer rid);
}
