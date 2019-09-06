package com.qfedu.dt.service.impl;

import com.qfedu.dt.dao.CorrectManageDao;
import com.qfedu.dt.service.CorrectManageService;
import com.qfedu.dt.vo.Studentexamanswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorrectManageServiceImpl implements CorrectManageService {

    @Autowired(required= false)
    private CorrectManageDao correctManageDao;
    @Override
    public List<Studentexamanswer> findByStudent(Integer eId) {
        return correctManageDao.findByStudent(eId);
    }

    @Override
    public String findByfindBystudentanswer(Integer sid,Integer eid) {
        return correctManageDao.findBystudentanswer(sid,eid);
    }

    @Override
    public int findByGid(Integer sid, Integer eid) {
        return correctManageDao.findByGid(sid, eid);
    }

    @Override
    public void addSaqScore(Integer gid) {
         correctManageDao.addSaqScore(gid);
    }
}
