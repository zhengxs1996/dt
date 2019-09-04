package com.qfedu.dt.dao;

import com.qfedu.dt.vo.Exam;
import com.qfedu.dt.vo.ExamInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApplyDao {
    public List<ExamInfo> findAllExam();

    public void applyExam(@Param("sId") Integer sId,@Param("eId") Integer eId);

    public Integer findExam(Integer eId);

    public ExamInfo findBeginTime(Integer eId);
}
