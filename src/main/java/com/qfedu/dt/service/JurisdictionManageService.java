package com.qfedu.dt.service;

import com.qfedu.dt.entity.Permission;
import com.qfedu.dt.entity.Role;

import java.util.List;

public interface JurisdictionManageService {
    public List<Permission> findAll();

    public List<Role> findAllRole();

    public Integer[] getChecked(Integer rid);
    public void updatePrivilege( Integer rid,String[] privilegeArray);

}
