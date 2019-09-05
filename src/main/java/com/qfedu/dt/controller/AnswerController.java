package com.qfedu.dt.controller;

import com.qfedu.dt.common.JsonResult;
import com.qfedu.dt.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @RequestMapping("/addAnswer")
    public JsonResult addAnswer(String answer,Integer sid, Integer eid) {
        try {
            answerService.addAnswer(answer, sid, eid);
            return new JsonResult(1, "学生答案保存成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JsonResult(0, "试卷答案保存失败");

    }
}
