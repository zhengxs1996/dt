package com.qfedu.dt.dao;




import com.qfedu.dt.entity.JudgmentQuestions;
import com.qfedu.dt.entity.SimpleQuestions;
import com.qfedu.dt.vo.Simple;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SimpleQuestionsDao {

    //查找所有的简单题
    public List<Simple> findAllSimple(@Param("keyWord") String keyWord, @Param("courseId") Integer courseId, @Param("level") String level);
    //删除简答题
    public void deleteOneSimple(Integer id);
    //批量删除
    public void deleteAllSimple(Integer[] id);

    public void addAll(List<SimpleQuestions> list);

}
