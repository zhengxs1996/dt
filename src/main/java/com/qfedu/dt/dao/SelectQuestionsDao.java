package com.qfedu.dt.dao;

import com.qfedu.dt.entity.Course;
import com.qfedu.dt.entity.JudgmentQuestions;
import com.qfedu.dt.vo.Selects;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SelectQuestionsDao {

    public List<Selects> findAll(@Param("keyWord") String keyWord, @Param("courseId") Integer courseId, @Param("level") String level);

    public List<Course> findAllCourse();

    public void deleteOneSelect(Integer id);

    public void deleteAllSelect(Integer[] id);

    //查找所有的判断题
    public List<JudgmentQuestions> findAllJudgment(@Param("keyWord") String keyWord, @Param("courseId") Integer courseId, @Param("level") String level);
    //删除判断题
    public void deleteOneJudgment(Integer id);
    //批量删除
    public void deleteAllJudgment(Integer[] id);
}
