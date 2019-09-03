package com.qfedu.dt.service.impl;

import com.qfedu.dt.dao.PracticeDao;
import com.qfedu.dt.entity.JudgmentQuestions;
import com.qfedu.dt.entity.SelectQuestions;
import com.qfedu.dt.entity.SimpleQuestions;
import com.qfedu.dt.service.PracticeService;
import com.qfedu.dt.vo.Exam;
import com.qfedu.dt.vo.Values;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PracticeServiceImpl implements PracticeService {

    @Autowired(required = false)
    private PracticeDao practiceDao;

    @Override
    public List<Exam> createPaper() {

        ArrayList<Exam> exams = new ArrayList<>();
        Exam exam1 = new Exam();

        //TODO 获取三种试题,暂定十道选择,五道判断,两道简答
        List<SelectQuestions> selects = practiceDao.createSelect();
        List<JudgmentQuestions> judgments = practiceDao.createJudgment();
        List<SimpleQuestions> simples = practiceDao.createSimple();

        List<Values> valueSelect = new ArrayList<>();
        //遍历保存选择题
        for (SelectQuestions select : selects) {
            Values temp = new Values();
            ArrayList<String> answers = new ArrayList<>();
            temp.setType(1);
            temp.setQuestionStem(select.getQuestion());

            ArrayList<String> options = new ArrayList<>();
            options.add(select.getOptionA());
            options.add(select.getOptionB());
            options.add(select.getOptionC());
            options.add(select.getOptionD());

            temp.setOptions(options);
            answers.add(select.getAnswer());
            temp.setAnswer(answers);
            valueSelect.add(temp);
        }
        exam1.setTitle("单项选择题");
        exam1.setValues(valueSelect);
        exams.add(exam1);

        Exam exam2 = new Exam();
        List<Values> valueJurisdiction = new ArrayList<>();
        //遍历保存判断题
        for (JudgmentQuestions judgment : judgments) {
            ArrayList<String> answers = new ArrayList<>();
            Values temp = new Values();
            temp.setType(3);
            temp.setQuestionStem(judgment.getQuestion());
            answers.add(judgment.getAnswer());
            temp.setAnswer(answers);
            valueJurisdiction.add(temp);
        }
        exam2.setTitle("判断题");
        exam2.setValues(valueJurisdiction);
        exams.add(exam2);

        Exam exam3 = new Exam();
        List<Values> valueSimple = new ArrayList<>();
        //便利保存简答题
        for (SimpleQuestions simple : simples) {
            ArrayList<String> answers = new ArrayList<>();
            Values temp = new Values();
            temp.setType(5);
            temp.setQuestionStem(simple.getQuestion());
            answers.add(simple.getAnswer());
            temp.setAnswer(answers);
            valueSimple.add(temp);
        }
        exam3.setTitle("简答题");
        exam3.setValues(valueSimple);
        exams.add(exam3);

        return exams;
    }

    @Override
    public void addPaper(Integer eId, String jsonPaper) {
        practiceDao.addPaper(eId, jsonPaper);
    }

    @Override
    public String showPaper(Integer eId) {
        String jsonPaper = practiceDao.findPaper(eId);
        return jsonPaper;
    }
}
