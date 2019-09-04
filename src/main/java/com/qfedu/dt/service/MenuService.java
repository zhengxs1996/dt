package com.qfedu.dt.service;

import com.qfedu.dt.vo.MenuList;

import java.util.List;

public interface MenuService {
    public List<MenuList> menuList(Integer uId);
}
