package com.qfedu.dt.service;

public interface AnswerService {
    /**
     * 将学生答案存入数据库中
     * @param answer json格式的学会试卷答案
     */
    public void addAnswer(String answer,Integer sid, Integer eid);
}
