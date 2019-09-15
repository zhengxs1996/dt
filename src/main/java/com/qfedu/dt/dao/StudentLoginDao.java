package com.qfedu.dt.dao;

import org.apache.ibatis.annotations.Param;

public interface StudentLoginDao {
    /**
     * 找到指定学生的密码
     * @param email 学生邮箱信息
     * @return 密码
     */
    public String findStudentPassword(@Param("email") String email);

    /**
     * 查找指定邮箱学生的sid
     * @param email 学生邮箱
     * @return 返回学生id
     */
    public Integer findsid(@Param("email") String email);
}
