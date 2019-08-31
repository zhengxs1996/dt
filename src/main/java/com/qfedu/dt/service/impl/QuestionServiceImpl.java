package com.qfedu.dt.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.dt.dao.SelectQuestionsDao;
import com.qfedu.dt.entity.Course;
import com.qfedu.dt.service.QuestionService;
import com.qfedu.dt.vo.Selects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired(required = false)
    private SelectQuestionsDao selectQuestionsDao;

    @Override
    public List<Selects> selectList(Integer page, Integer limit, String keyWord, Integer courseId, String level) {
        PageHelper.startPage(page, limit);
        List<Selects> list = selectQuestionsDao.findAll(keyWord, courseId, level);
        while(true){
            if (list.size() != 0) {
                break;
            }
            PageHelper.startPage(--page, limit);
            list = selectQuestionsDao.findAll(keyWord, courseId, level);
        }
        return list;
    }

    @Override
    public List<Course> findAllCourse() {
        return selectQuestionsDao.findAllCourse();
    }

    @Override
    public void deleteOneSelect(Integer id) {
        selectQuestionsDao.deleteOneSelect(id);
    }

    @Override
    public void deleteAllSelect(Integer[] id) {
        selectQuestionsDao.deleteAllSelect(id);
    }
}
