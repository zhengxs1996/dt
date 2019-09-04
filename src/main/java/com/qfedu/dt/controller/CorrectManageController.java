package com.qfedu.dt.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.dt.common.JsonResult;
import com.qfedu.dt.service.CorrectManageService;
import com.qfedu.dt.vo.Studentexamanswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ObjIntConsumer;

@Controller
public class CorrectManageController {
    
    @Autowired
    private CorrectManageService correctManageService;

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

    @ResponseBody
    @RequestMapping("/Correct.do")
    public JsonResult findBySaqScore(Integer sid) {
        int saqScore=correctManageService.findBySaqScore(sid);
        return new JsonResult(0,"saqScore");
    }
}
