package com.qfedu.dt.service;

import java.util.List;

public interface ScoreMamagerService {

    //查询出来所有的名字
    public List<String> selectAllStudentName(Integer eid);
    //查询所有的成绩
    public List<Integer> selectAllScore(Integer eid);
}
