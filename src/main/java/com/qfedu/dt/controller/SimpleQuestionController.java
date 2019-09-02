package com.qfedu.dt.controller;

import com.github.pagehelper.Page;
import com.qfedu.dt.common.JsonResult;
import com.qfedu.dt.service.QuestionService;
import com.qfedu.dt.service.SimpleQuestionsService;
import com.qfedu.dt.vo.Simple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SimpleQuestionController {

    @Autowired
    private SimpleQuestionsService simpleQuestionsService;
    @Autowired
    private QuestionService questionService;

    /**
     * 判断题管理页面跳转
     * @return
     */
    @RequestMapping("/simpleManager")
    public String judgmentQuestions() {
        return "after/simpleQuestions";
    }

    /**
     * 简答题管理页面初始，搜索，筛选访问的资源
     * @param page
     * @param limit
     * @param keyWord
     * @param courseId
     * @param level
     * @return
     */
    @RequestMapping("/simpleList")
    @ResponseBody
    public Map<String, Object> simpleList(Integer page, Integer limit, String keyWord, Integer courseId, String level) {
        List<Simple> list = simpleQuestionsService.findAllSimple(page, limit, keyWord, courseId, level);
        long total = ((Page) list).getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);
        return map;
    }

    /**
     * 查询所有课程信息
     * @return
     */
//    @RequestMapping("/findAllCourse.do")
//    @ResponseBody
//    public JsonResult findAllCourse() {
//        List<Course> allCourse = questionService.findAllCourse();
//        return new JsonResult(1, allCourse);
//    }

    /**
     * 删除指定一条简答题
     * @param id
     * @return
     */
    @RequestMapping("/deleteOneSimple")
    @ResponseBody
    public JsonResult deleteOneSimple(Integer id) {
        try {
            simpleQuestionsService.deleteOneSimple(id);
            return new JsonResult(1, "删除成功");
        } catch (Exception e) {
            return new JsonResult(0, e.getMessage());
        }
    }

    /**
     * 批量删除简答题
     * @param id
     * @return
     */
    @RequestMapping("/deleteAllSimple")
    @ResponseBody
    public JsonResult deleteAll(@RequestParam(value="id[]") Integer[] id) {
        try {
            simpleQuestionsService.deleteAllSimple(id);
            return new JsonResult(1, "删除成功");
        } catch (Exception e) {
            return new JsonResult(0, e.getMessage());
        }
    }

    /**
     * 判断题批量导入
     * @return
     */
    @RequestMapping("/uploadSimple")
    @ResponseBody
    public Map<String, Object> uploadSimple(@RequestParam("file") MultipartFile file) {
        simpleQuestionsService.uploadSimple(file);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "上传成功");
        return map;
    }

}
