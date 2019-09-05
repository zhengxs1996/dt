package com.qfedu.dt.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.dt.dao.ApplyDao;
import com.qfedu.dt.service.ApplyService;
import com.qfedu.dt.vo.ExamInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: dt
 * @description:
 * @author: sjm
 * @create: 2019-09-02 15:22
 **/

@Service
public class ApplyServiceImpl implements ApplyService {
    @Autowired(required = false)
    private ApplyDao applyDao;
    @Override
    public List<ExamInfo> findAllExam(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<ExamInfo> examList = applyDao.findAllExam();
        return examList;
    }

    @Override
    public Integer applyExam(Integer sId, Integer eId) {
        ExamInfo examInfo = applyDao.findBeginTime(eId);
        Date currentTime = new Date();
        Date beginTime = examInfo.getBeginTime();
        if (currentTime.after(beginTime)){
            return 2;
        }else {
            Integer stu = applyDao.findExam(eId);
            if (stu == null){
                applyDao.applyExam(sId,eId);
                return 0;
            }else {
                return 1;
            }
        }
    }
}
