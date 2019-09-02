package com.qfedu.dt.service;

import com.qfedu.dt.entity.Course;
import com.qfedu.dt.entity.ExamManage;
import com.qfedu.dt.vo.VExamManage;

import java.util.List;

public interface ExamManageService {
    public void addExamManage(ExamManage examManage);

    public void deleteExamManage(Integer eId);

    public void updateExamManage(ExamManage examManage);

    public VExamManage findByExamManageId(Integer eId);

    public ExamManage findExamByEId(Integer eId);

    public List<VExamManage> findAllExamManage(Integer page, Integer limit);

    public List<Course> findAllCourse();
}
