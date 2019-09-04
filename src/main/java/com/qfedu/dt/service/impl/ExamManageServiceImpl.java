package com.qfedu.dt.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.dt.dao.ExamManageDao;
import com.qfedu.dt.entity.Course;
import com.qfedu.dt.entity.ExamManage;
import com.qfedu.dt.service.ExamManageService;
import com.qfedu.dt.vo.VExamManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamManageServiceImpl implements ExamManageService {

    @Autowired(required = false)
    private ExamManageDao examManageDao;

    @Override
    public void addExamManage(ExamManage examManage) {
        examManageDao.add(examManage);
    }

    @Override
    public void deleteExamManage(Integer eId) {
        examManageDao.delete(eId);
    }

    @Override
    public void updateExamManage(ExamManage examManage) {
        examManageDao.update(examManage);
    }

    @Override
    public VExamManage findByExamManageId(Integer eId) {
        return examManageDao.findById(eId);
    }

    @Override
    public ExamManage findExamByEId(Integer eId) {
        return examManageDao.findExamById(eId);
    }

    @Override
    public List<VExamManage> findAllExamManage(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        return examManageDao.findAll();
    }

    @Override
    public List<Course> findAllCourse() {
        return examManageDao.findCourse();
    }

    @Override
    public List<ExamManage> findExamByMyself(Integer page, Integer limit, Integer sid) {
        PageHelper.startPage(page, limit);
        return examManageDao.findExamByMyself(sid);
    }
}
