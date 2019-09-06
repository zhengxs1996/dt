package com.qfedu.dt.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.dt.entity.AnswerInfo;
import com.qfedu.dt.service.CorrectManageService;
import com.qfedu.dt.service.PracticeService;
import com.qfedu.dt.untils.JsonResult;
import com.qfedu.dt.untils.JsonUtils;
import com.qfedu.dt.vo.Exam;
import com.qfedu.dt.vo.PiGaiShow;
import com.qfedu.dt.vo.Studentexamanswer;
import com.qfedu.dt.vo.Values;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class CorrectManageController {
    
    @Autowired
    private CorrectManageService correctManageService;

    @Autowired
    private PracticeService practiceService;

    @RequestMapping("/StudentSCorrect.do")
    @ResponseBody
    public Map<String, Object> findByStudent(Integer page,Integer limit,Integer eId){
        PageHelper.startPage(page, limit);
        List<Studentexamanswer> list=correctManageService.findByStudent(eId);
        long total=((Page) list).getTotal();
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",list);

        return map;
    }

    @RequestMapping("/Student")
    public String toAddExam(){
        return "after/showStudentScore";
    }

    @RequestMapping("/Correct")
    public String Correct(){
        return "after/showSaqScore";
    }

    @ResponseBody
    @RequestMapping("/Correct.do")
    public Map<String, Object> findBySaqScore(Integer page, Integer limit, Integer sid, Integer eid) {
        String studentanswer=correctManageService.findByfindBystudentanswer(sid, eid);
        int gid=correctManageService.findByGid(sid, eid);
        //使用Json工具将Json格式转化成java对象,将储存在json中的学生答案取出来
        AnswerInfo answerInfo=JsonUtils.jsonToClass(studentanswer, AnswerInfo.class);
        String shortAnswer1=answerInfo.getShortAnswer1();
        String shortAnswer2=answerInfo.getShortAnswer2();
        String jsonPaper = practiceService.showPaper(eid);

        //使用Json工具将Json格式转化成java对象,将储存在json中的参考答案取出来
        List<Exam> examList = JsonUtils.jsonToList(jsonPaper, Exam.class);
        List<Values> values=examList.get(2).getValues();

        PageHelper.startPage(page, limit);

        List<PiGaiShow> list=new ArrayList<PiGaiShow>();
        PiGaiShow piGaiShow = new PiGaiShow();
        piGaiShow.setQuestion(values.get(0).getQuestionStem());
        piGaiShow.setAnwer(values.get(0).getAnswer().get(0));
        piGaiShow.setSrtudentnwer(shortAnswer1);
        list.add(piGaiShow);

        piGaiShow.setQuestion(values.get(1).getQuestionStem());
        piGaiShow.setAnwer(values.get(1).getAnswer().get(0));
        piGaiShow.setSrtudentnwer(shortAnswer2);
        piGaiShow.setGid(gid);
        list.add(piGaiShow);

        Map<String, Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",2);
        map.put("data",list);
        return map;
    }
    @RequestMapping("/addSaqScore.do")
    @ResponseBody
    public JsonResult addSaqScore(Integer gid, Integer score) {
        correctManageService.addSaqScore(gid,score);
        return new JsonResult(0,null);
    }
}

