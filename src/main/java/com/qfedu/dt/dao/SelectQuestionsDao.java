package com.qfedu.dt.dao;

import com.qfedu.dt.entity.Course;
import com.qfedu.dt.entity.SelectQuestions;
import com.qfedu.dt.vo.Selects;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SelectQuestionsDao {

    public List<Selects> findAll(@Param("keyWord") String keyWord, @Param("courseId") Integer courseId, @Param("level") String level);

    public List<Course> findAllCourse();

    public void deleteOneSelect(Integer id);

    public void deleteAllSelect(Integer[] id);

    public void addAll(List<SelectQuestions> list);
}
