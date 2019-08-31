package com.qfedu.dt.controller;

import com.github.pagehelper.Page;
import com.qfedu.dt.common.JsonResult;
import com.qfedu.dt.entity.Course;
import com.qfedu.dt.entity.SelectQuestions;
import com.qfedu.dt.service.QuestionService;
import com.qfedu.dt.vo.Selects;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping("/selectManager")
    public String selectQuestions() {
        return "after/selectQuestions";
    }

    @RequestMapping("/selectList")
    @ResponseBody
    public Map<String, Object> selectList(Integer page, Integer limit, String keyWord, Integer courseId, String level) {
        List<Selects> list = questionService.selectList(page, limit, keyWord, courseId, level);
        long total = ((Page) list).getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);
        return map;
    }

    @RequestMapping("/findAllCourse.do")
    @ResponseBody
    public JsonResult findAllCourse() {
        List<Course> allCourse = questionService.findAllCourse();
        return new JsonResult(1, allCourse);
    }

    @RequestMapping("/deleteOneSelect")
    @ResponseBody
    public JsonResult deleteVideo(Integer id) {
        try {
            questionService.deleteOneSelect(id);
            return new JsonResult(1, "删除成功");
        } catch (Exception e) {
            return new JsonResult(0, e.getMessage());
        }
    }

    @RequestMapping("/deleteAllSelect")
    @ResponseBody
    public JsonResult deleteAll(@RequestParam(value="id[]") Integer[] id) {
        try {
            questionService.deleteAllSelect(id);
            return new JsonResult(1, "删除成功");
        } catch (Exception e) {
            return new JsonResult(0, e.getMessage());
        }
    }
}
