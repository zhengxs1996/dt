package com.qfedu.dt.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.dt.dao.JudgmentQuestionsDao;
import com.qfedu.dt.dao.SimpleQuestionsDao;
import com.qfedu.dt.service.JudgmentQuestionService;
import com.qfedu.dt.service.SimpleQuestionsService;
import com.qfedu.dt.vo.Judgment;
import com.qfedu.dt.vo.Simple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleQuestionServiceImpl implements SimpleQuestionsService {

    @Autowired(required = false)
    private SimpleQuestionsDao simpleQuestionsDao;

    //展示所有的简答题
    @Override
    public List<Simple> findAllSimple(Integer page, Integer limit, String keyWord, Integer courseId, String level) {
        PageHelper.startPage(page, limit);
        List<Simple> list = simpleQuestionsDao.findAllSimple(keyWord, courseId, level);
        while(true){
            if (list.size() != 0) {
                break;
            }
            PageHelper.startPage(--page, limit);
            list = simpleQuestionsDao.findAllSimple(keyWord, courseId, level);
        }
        return list;
    }



    //删除一道简答题
    @Override
    public void deleteOneSimple(Integer id) {
        simpleQuestionsDao.deleteOneSimple(id);

    }

    //批量删除判断题
    @Override
    public void deleteAllSimple(Integer[] id) {
        simpleQuestionsDao.deleteAllSimple(id);


    }

}
