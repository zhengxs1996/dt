package com.qfedu.dt.dao;

import com.qfedu.dt.entity.ExamManage;
import org.apache.ibatis.annotations.Param;

public interface ExamDao {
    public ExamManage findPaper(Integer eid);

    public void storeAnswer(@Param("studentanswer") String srudentanswer,@Param("selectscore") Integer selectscore,@Param("judgmentscore") Integer judgmentscore, @Param("sid") Integer sid, @Param("eid") Integer eid);
}
