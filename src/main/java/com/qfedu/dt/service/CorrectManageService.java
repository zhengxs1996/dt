package com.qfedu.dt.service;

import com.qfedu.dt.vo.Studentexamanswer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CorrectManageService {
    //展示对应场次的学生试卷
    public List<Studentexamanswer> findByStudent(Integer eId);

    //展示对应场次的学生试卷简答题
    public String findByfindBystudentanswer(Integer sid,Integer eid);
    //查找gid
    public int findByGid(Integer sid, Integer eid);
    //
    public void addSaqScore(Integer gid,Integer score);
}
