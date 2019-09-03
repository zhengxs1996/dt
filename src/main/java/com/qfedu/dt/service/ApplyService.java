package com.qfedu.dt.service;


import com.qfedu.dt.vo.ExamInfo;

import java.util.List;

public interface ApplyService {
    public List<ExamInfo> findAllExam(Integer page, Integer limit);

    public Integer applyExam(Integer sId,Integer eId);
}
