package com.qfedu.dt.service.impl;

import com.qfedu.dt.dao.AnswerDao;
import com.qfedu.dt.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerDao answerDao;

    @Override
    public void addAnswer(String answer,Integer sid, Integer eid) {
        answerDao.addAnswer(answer, sid, eid);
    }
}
