package com.qfedu.dt.service;

import com.qfedu.dt.vo.Exam;

import java.util.List;

public interface PracticeService {

    /**
     * 随机生成试卷信息
     * @return 返回试卷对象
     */
    public List<Exam> createPaper();

    /**
     * 添加json格式的试卷对象到考次表中
     * @param eId 考次编码
     * @param jsonPaper json的试卷对象
     */
    public void addPaper(Integer eId, String jsonPaper);

    /**
     * 找到考次对应的试卷信息
     * @param eId 考次id
     * @return 返回json格式的试卷对象
     */
    public String showPaper(Integer eId);
}
