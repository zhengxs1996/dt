package com.qfedu.dt.dao;


import com.qfedu.dt.vo.MenuList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDao {
    public List<MenuList> MenuList(@Param("uId") Integer uId);
}
