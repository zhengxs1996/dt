package com.qfedu.dt.controller;

import com.github.pagehelper.Page;
import com.qfedu.dt.common.JsonResult;
import com.qfedu.dt.common.Layui;
import com.qfedu.dt.entity.Course;
import com.qfedu.dt.entity.ExamManage;
import com.qfedu.dt.service.ExamManageService;
import com.qfedu.dt.vo.VExamManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ExamManageController {

    @Autowired
    private ExamManageService examManageService;

    @RequestMapping("/toExamList")
    public String toExamManage() {
        return "after/exam";
    }

    @RequestMapping("/correct")
    public String toCorrect() {
        return "after/correct";
    }

    @RequestMapping("/exam/checkOneExam")
    public String findAExamManage(Model model, Integer eId) {
        VExamManage vExamManage = examManageService.findByExamManageId(eId);
        String str = "第" + eId + "考次";
        model.addAttribute("title", str);
        model.addAttribute("vExamManage", vExamManage);
        return "after/checkOneExam";
    }

    @RequestMapping("/exam/list")
    @ResponseBody
    public Layui findALlExamManage(Integer page, Integer limit) {
        List<VExamManage> allExamManage = examManageService.findAllExamManage(page, limit);
        long count = ((Page) allExamManage).getTotal();
        return Layui.data(count, allExamManage);
    }

    @RequestMapping("/toAdd")
    public String toAddExam(){
        return "after/addExam";
    }

    @RequestMapping("/exam/add")
    @ResponseBody
    public JsonResult addExam(ExamManage examManage){
        examManageService.addExamManage(examManage);
        return new JsonResult(1,null);
    }

    @RequestMapping("/exam/delete")
    @ResponseBody
    public JsonResult deleteExam(Integer eId) {
        examManageService.deleteExamManage(eId);
        return new JsonResult(1, null);
    }

    //-------------修改相关-----------------
    @RequestMapping("/toUpdate")
    public String toUpdateExam(Model model,Integer eId) {
        ExamManage exam = examManageService.findExamByEId(eId);
        model.addAttribute("exam",exam);
        return "after/updateExam";
    }

    @RequestMapping("/exam/update")
    @ResponseBody
    public JsonResult updateExam(ExamManage examManage) {
        examManageService.updateExamManage(examManage);
        return new JsonResult(1,null);
    }

    @RequestMapping("/exam/findVExam")
    public JsonResult findVExamByEId(Integer eId){
        VExamManage vExamManage = examManageService.findByExamManageId(eId);
        return new JsonResult(1,vExamManage);
    }

    @RequestMapping("/exam/findExam")
    public JsonResult findExamByEId(Integer eId){
        ExamManage exam = examManageService.findExamByEId(eId);
        return new JsonResult(1,exam);
    }

    @RequestMapping("/exam/findCourse")
    @ResponseBody
    public JsonResult findAllCourse(){
        List<Course> allCourse = examManageService.findAllCourse();
        return new JsonResult(1,allCourse);
    }
}
