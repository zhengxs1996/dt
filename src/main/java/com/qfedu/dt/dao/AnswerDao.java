package com.qfedu.dt.dao;

import org.apache.ibatis.annotations.Param;

public interface AnswerDao {
    /**
     * 将学生试卷的答案保存到表中
     * @param answer 学生试卷json格式的答案
     */
    public void addAnswer(@Param("answer") String answer,@Param("sid") Integer sid,@Param("eid") Integer eid);
}
