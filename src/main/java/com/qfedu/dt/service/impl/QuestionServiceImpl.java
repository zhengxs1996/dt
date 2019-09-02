package com.qfedu.dt.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.dt.dao.SelectQuestionsDao;
import com.qfedu.dt.entity.Course;
import com.qfedu.dt.entity.JudgmentQuestions;
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

    //展示所有的判断题
    @Override
    public List<JudgmentQuestions> findAllJudgment(Integer page, Integer limit, String keyWord, Integer courseId, String level) {
        PageHelper.startPage(page, limit);
        List<JudgmentQuestions> list = selectQuestionsDao.findAllJudgment(keyWord, courseId, level);
        while(true){
            if (list.size() != 0) {
                break;
            }
            PageHelper.startPage(--page, limit);
            list = selectQuestionsDao.findAllJudgment(keyWord, courseId, level);
        }
        return list;
    }

    //删除一道判断题
    @Override
    public void deleteOneJudgment(Integer id) {
        selectQuestionsDao.deleteOneSelect(id);

    }

    //批量删除判断题
    @Override
    public void deleteAllJudgment(Integer[] id) {
        selectQuestionsDao.deleteAllJudgment(id);

    }
}
