package com.qfedu.dt.dao;

import com.qfedu.dt.entity.JudgmentQuestions;
import com.qfedu.dt.entity.SelectQuestions;
import com.qfedu.dt.entity.SimpleQuestions;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PracticeDao {

    public List<SelectQuestions> createSelect();

    public List<JudgmentQuestions> createJudgment();

    public List<SimpleQuestions> createSimple();

    /**
     * 添加json格式的试卷信息到考次信息表中
     * @param eId 考次Id
     * @param jsonPaper json格式的试卷对象
     */
    public void addPaper(@Param("eId") Integer eId,@Param("jsonPaper") String jsonPaper);

    /**
     * 找到对应场次的试卷内容
     * @param eId 考次id
     * @return 返回考次表中的json格式的试卷对象
     */
    public String findPaper(@Param("eId") Integer eId);

}
