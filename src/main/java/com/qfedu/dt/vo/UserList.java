package com.qfedu.dt.vo;

import com.qfedu.dt.entity.Role;

import java.util.List;


public class UserList {
    private Integer uid;
    private String username;
    private String password;
    private List<Role> role;
    private String roleName;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid=uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username=username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password=password;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role=role;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName=roleName;
    }
}
