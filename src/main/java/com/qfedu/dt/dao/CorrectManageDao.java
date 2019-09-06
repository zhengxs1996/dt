package com.qfedu.dt.dao;

import com.qfedu.dt.vo.Studentexamanswer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CorrectManageDao {
    public List<Studentexamanswer> findByStudent(Integer eId);

    public String findBystudentanswer(@Param("sid") Integer sid,
                                      @Param("eid") Integer eid);
    public void   addSaqScore(Integer sid);

    public int findByGid (@Param("sid")Integer sid, @Param("eid") Integer eid);
}
