package com.qfedu.dt.dao;



import com.qfedu.dt.vo.Judgment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JudgmentQuestionsDao {


    //查找所有的判断题
    public List<Judgment> findAllJudgment(@Param("keyWord") String keyWord, @Param("courseId") Integer courseId, @Param("level") String level);
    //删除判断题
    public void deleteOneJudgment(Integer id);
    //批量删除
    public void deleteAllJudgment(Integer[] id);

}
