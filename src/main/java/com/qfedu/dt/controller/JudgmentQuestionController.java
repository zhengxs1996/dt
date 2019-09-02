package com.qfedu.dt.controller;

import com.github.pagehelper.Page;
import com.qfedu.dt.common.JsonResult;
import com.qfedu.dt.entity.Course;
import com.qfedu.dt.service.JudgmentQuestionService;
import com.qfedu.dt.service.QuestionService;
import com.qfedu.dt.vo.Judgment;
import com.qfedu.dt.vo.Selects;
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
public class JudgmentQuestionController {

    @Autowired
    private JudgmentQuestionService judgmentQuestionService;
    @Autowired
    private QuestionService questionService;

    /**
     * 判断题管理页面跳转
     * @return
     */
    @RequestMapping("/judgmentManager")
    public String judgmentQuestions() {
        return "after/judgmentQuestions";
    }

    /**
     * 判断题管理页面初始，搜索，筛选访问的资源
     * @param page
     * @param limit
     * @param keyWord
     * @param courseId
     * @param level
     * @return
     */
    @RequestMapping("/judgmentList")
    @ResponseBody
    public Map<String, Object> selectList(Integer page, Integer limit, String keyWord, Integer courseId, String level) {
        List<Judgment> list = judgmentQuestionService.findAllJudgment(page, limit, keyWord, courseId, level);
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
     * 删除指定一条判断题
     * @param id
     * @return
     */
    @RequestMapping("/deleteOneJudgment")
    @ResponseBody
    public JsonResult deleteOneJudgment(Integer id) {
        try {
            judgmentQuestionService.deleteOneJudgment(id);
            return new JsonResult(1, "删除成功");
        } catch (Exception e) {
            return new JsonResult(0, e.getMessage());
        }
    }

    /**
     * 批量删除判断题
     * @param id
     * @return
     */
    @RequestMapping("/deleteAllJudgment")
    @ResponseBody
    public JsonResult deleteAll(@RequestParam(value="id[]") Integer[] id) {
        try {
            judgmentQuestionService.deleteAllJudgment(id);
            return new JsonResult(1, "删除成功");
        } catch (Exception e) {
            return new JsonResult(0, e.getMessage());
        }
    }

    /**
     * 判断题批量导入
     * @return
     */
    @RequestMapping("/uploadJudgment")
    @ResponseBody
    public Map<String, Object> uploadJudgment(@RequestParam("file") MultipartFile file) {

        judgmentQuestionService.uploadJudgment(file);

        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "上传成功");

        return map;

    }

}
