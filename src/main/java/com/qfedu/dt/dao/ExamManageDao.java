package com.qfedu.dt.dao;

import com.qfedu.dt.entity.Course;
import com.qfedu.dt.entity.ExamManage;
import com.qfedu.dt.vo.VExamManage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamManageDao {
    public void add(ExamManage examManage);

    public void delete(Integer eId);

    public void update(ExamManage examManage);

    public VExamManage findById(Integer eId);

    public ExamManage findExamById(Integer eId);

    public List<VExamManage> findAll();

    public List<Course> findCourse();

    public List<ExamManage> findExamByMyself(@Param("sid") Integer sid);

}
