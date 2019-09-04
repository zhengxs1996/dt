package com.qfedu.dt.dao;

import com.qfedu.dt.vo.Studentexamanswer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CorrectManageDao {
    public List<Studentexamanswer> findByStudent(Integer eId);

    public int findBySaqScore(Integer sid);
}
