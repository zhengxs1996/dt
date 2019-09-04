package com.qfedu.dt.service.impl;

import com.qfedu.dt.dao.MenuDao;
import com.qfedu.dt.service.MenuService;
import com.qfedu.dt.vo.MenuList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired(required = false)
    private MenuDao menuDao;

    @Override
    public List<MenuList> menuList(Integer uId) {
        return menuDao.MenuList(uId);
    }
}
