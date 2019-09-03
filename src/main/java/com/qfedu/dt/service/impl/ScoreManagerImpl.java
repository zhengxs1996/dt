package com.qfedu.dt.service.impl;

import com.qfedu.dt.dao.ScoreMamagerDao;
import com.qfedu.dt.service.ScoreMamagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreManagerImpl implements ScoreMamagerService {
    @Autowired
    private ScoreMamagerDao scoreMamagerDao;

    @Override
    public List<String> selectAllStudentName(Integer eid) {
        return scoreMamagerDao.selectAllStudentName(eid);
    }

    @Override
    public List<Integer> selectAllScore(Integer eid) {
        return scoreMamagerDao.selectAllScore(eid);
    }
}
