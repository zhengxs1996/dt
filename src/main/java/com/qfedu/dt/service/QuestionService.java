package com.qfedu.dt.service;

import com.qfedu.dt.entity.Course;
import com.qfedu.dt.entity.JudgmentQuestions;
import com.qfedu.dt.vo.Selects;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionService {

    public List<Selects> selectList(Integer page, Integer limit, String keyWord, Integer courseId, String level);

    public List<Course> findAllCourse();

    public void deleteOneSelect(Integer id);

    public void deleteAllSelect(Integer[] id);

    //查找所有的判断题
    public List<JudgmentQuestions> findAllJudgment(Integer page, Integer limit, String keyWord, Integer courseId, String level);

    //删除判断题
    public void deleteOneJudgment(Integer id);
    //批量删除
    public void deleteAllJudgment(Integer[] id);
}
