package com.qfedu.dt.service.impl;

import com.qfedu.dt.dao.ExamDao;
import com.qfedu.dt.entity.AnswerInfo;
import com.qfedu.dt.entity.ExamManage;
import com.qfedu.dt.service.ExamService;
import com.qfedu.dt.untils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: dt
 * @description:
 * @author: sjm
 * @create: 2019-09-04 16:37
 **/
@Service
public class ExamServiceImpl implements ExamService {
    @Autowired(required = false)
    private ExamDao examDao;
    @Override
    public ExamManage findPaper(Integer eId) {
        ExamManage examInfo = examDao.findPaper(eId);
        return examInfo;
    }

    @Override
    public void storeAnswer(AnswerInfo answer, Integer selectscore, Integer judgmentscore,Integer sid, Integer eid) {
        String answerStr = JsonUtils.objectToJson(answer);
        examDao.storeAnswer(answerStr,selectscore,judgmentscore,sid,eid);
    }
}
