package com.qfedu.dt.controller;

import com.github.pagehelper.Page;
import com.qfedu.dt.entity.ExamManage;
import com.qfedu.dt.entity.Student;
import com.qfedu.dt.service.ExamManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/before")
@CrossOrigin
public class ExamByMyselfController {

    @Autowired
    private ExamManageService examManageService;

    @RequestMapping("/findExamByMyself")
    @ResponseBody
    public Map<String, Object> findExamByMyself(Integer page, Integer limit, Integer sid) {
        List<ExamManage> list = examManageService.findExamByMyself(page, limit, sid);
        long total = ((Page) list).getTotal();

        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);
        return map;
    }
}
