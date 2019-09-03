package com.qfedu.dt.dao;

import com.qfedu.dt.entity.JudgmentQuestions;
import com.qfedu.dt.entity.SelectQuestions;
import com.qfedu.dt.entity.SimpleQuestions;

import java.util.List;

public interface PracticeDao {

    public List<SelectQuestions> createSelect();

    public List<JudgmentQuestions> createJudgment();

    public List<SimpleQuestions> createSimple();
}
