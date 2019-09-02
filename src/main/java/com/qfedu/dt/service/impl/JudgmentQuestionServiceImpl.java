package com.qfedu.dt.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.qfedu.dt.dao.JudgmentQuestionsDao;
import com.qfedu.dt.dao.SelectQuestionsDao;
import com.qfedu.dt.entity.Course;
import com.qfedu.dt.entity.JudgmentQuestions;
import com.qfedu.dt.entity.SelectQuestions;
import com.qfedu.dt.service.JudgmentQuestionService;
import com.qfedu.dt.service.QuestionService;

import com.qfedu.dt.vo.Judgment;
import com.qfedu.dt.vo.Selects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Service
public class JudgmentQuestionServiceImpl implements JudgmentQuestionService {

    @Autowired(required = false)
    private JudgmentQuestionsDao judgmentQuestionsDao;

    //展示所有的判断题
    @Override
    public List<Judgment> findAllJudgment(Integer page, Integer limit, String keyWord, Integer courseId, String level) {
        PageHelper.startPage(page, limit);
        List<Judgment> list = judgmentQuestionsDao.findAllJudgment(keyWord, courseId, level);
        while(true){
            if (list.size() != 0) {
                break;
            }
            PageHelper.startPage(--page, limit);
            list = judgmentQuestionsDao.findAllJudgment(keyWord, courseId, level);
        }
        return list;
    }

    //删除一道判断题
    @Override
    public void deleteOneJudgment(Integer id) {
        judgmentQuestionsDao.deleteOneJudgment(id);

    }

    //批量删除判断题
    @Override
    public void deleteAllJudgment(Integer[] id) {
        judgmentQuestionsDao.deleteAllJudgment(id);


    }

}
