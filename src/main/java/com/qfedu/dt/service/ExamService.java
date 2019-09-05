package com.qfedu.dt.service;

import com.qfedu.dt.entity.AnswerInfo;
import com.qfedu.dt.entity.ExamManage;

/**
 * @program: dt
 * @description:
 * @author: sjm
 * @create: 2019-09-04 16:37
 **/
public interface ExamService {
    public ExamManage findPaper(Integer eId);

    public void storeAnswer(AnswerInfo answer,Integer selectscore, Integer judgmentscorem ,Integer sid, Integer eid);

}
