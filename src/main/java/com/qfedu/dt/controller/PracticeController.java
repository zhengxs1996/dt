package com.qfedu.dt.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qfedu.dt.common.JsonResult;
import com.qfedu.dt.service.PracticeService;
import com.qfedu.dt.untils.JsonUtils;
import com.qfedu.dt.vo.Exam;
import jdk.internal.org.objectweb.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
public class PracticeController {

    @Autowired
    private PracticeService practiceService;

    @RequestMapping("/before/practice")
    public String practice() {
        return "/before/practice";
    }

    @RequestMapping("/before/createPaper")
    @ResponseBody
    public Map<String, Object> examPractice(Integer courseId) {
        
        List<Exam> examList = practiceService.createPaper();

        HashMap<String, Object> map = new HashMap<>();
        map.put("title", "在线考试");
        map.put("exam", examList);
        return map;
    }

    /**
     * 后台考次管理中添加试卷的功能访问的资源
     * @return
     */
    @RequestMapping("/createPaper")
    @ResponseBody
    public JsonResult createPaper(Integer eId) {

        List<Exam> examList = practiceService.createPaper();

        try {
            //将试卷对象转成json格式存入考次表中
            String jsonPaper = JsonUtils.objectToJson(examList);
            practiceService.addPaper(eId, jsonPaper);
            return new JsonResult(1, "试卷生成成功");
        } catch (Exception e) {
            return new JsonResult(0, e.getMessage());
        }

    }

    @RequestMapping("/showExamPaper")
    public String showExamPaper(Integer eId, Model model) {
        model.addAttribute("eId", eId);
        return "after/showPaper";
    }

    @RequestMapping("/showPaper")
    @ResponseBody
    public Map<String, Object> showPaper(Integer eId) {
        String jsonPaper = practiceService.showPaper(eId);
        List<Exam> examList = JsonUtils.jsonToList(jsonPaper, Exam.class);
        HashMap<String, Object> map = new HashMap<>();
        if (examList != null) {
            examList = JsonUtils.jsonToList(jsonPaper, Exam.class);
            map.put("title", "试卷内容");
            map.put("exam", examList);
            return map;
        } else {
            map.put("result", "试卷未生成");
            return map;
        }
    }

}
