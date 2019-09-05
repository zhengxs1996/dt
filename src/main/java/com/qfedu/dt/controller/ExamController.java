package com.qfedu.dt.controller;


import com.qfedu.dt.common.JsonResult;
import com.qfedu.dt.entity.AnswerInfo;
import com.qfedu.dt.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: dt
 * @description:
 * @author: sjm
 * @create: 2019-09-04 16:33
 **/

@RequestMapping("/before/exam")
@Controller
public class ExamController {
    @Autowired
    private ExamService examService;

    @ResponseBody
    @RequestMapping("/findPaper.do")
    public Map<String,Object> findPaper(Integer eId){
        Map<String,Object> map = new HashMap<>();
        String paper = examService.findPaper(eId).getPaper();
        Integer totalTime = examService.findPaper(eId).getTotalTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        map.put("info",paper);
        map.put("totalTime",totalTime);
        return map;
    }

    @ResponseBody
    @RequestMapping("/submitAnswer.do")
    public JsonResult submitAnswer(AnswerInfo answer, Integer sid, Integer eid, Integer selectScore,Integer judgeScore,HttpServletRequest request){
        //Integer sId = Integer.parseInt( request.getHeader("sId"));
        System.out.println(answer);
        System.out.println(selectScore);
        System.out.println(judgeScore);
        examService.storeAnswer(answer,selectScore,judgeScore,sid,eid);

        return new JsonResult(0,"成功");
    }
}
