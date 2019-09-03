package com.qfedu.dt.controller;

import com.qfedu.dt.service.PracticeService;
import com.qfedu.dt.vo.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String, Object> createPaper(Integer courseId) {
        
        List<Exam> examList = practiceService.createPaper();

        HashMap<String, Object> map = new HashMap<>();
        map.put("title", "在线考试");
        map.put("exam", examList);
        return map;
    }

}
