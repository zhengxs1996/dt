package com.qfedu.dt.controller;


import com.github.pagehelper.Page;
import com.qfedu.dt.common.JsonResult;
import com.qfedu.dt.entity.Student;
import com.qfedu.dt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired(required = false)
    private StudentService studentService;


    @RequestMapping("/list.do")
    public String studentList(){
        return "after/studentManage";
    }


    @RequestMapping("/findAllStudent.do")
    @ResponseBody
    public Map<String,Object> findAllStudent(Integer page, Integer limit,String sname){
        List<Student> students = studentService.findAllStudent(page,limit,sname);
        long total = ((Page) students).getTotal();
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",students);
       return map;
    }

    @RequestMapping("/add.do")
    public String add(){
        return "after/addStudent";
    }

    @RequestMapping("/addStudent.do")
    @ResponseBody
    public JsonResult addStudent(Student student){
        studentService.addStudent(student);
        JsonResult jsonResult = new JsonResult(0, null);
        return jsonResult;
    }

    @RequestMapping("/findStudentById.do")
    @ResponseBody
    public JsonResult findStudentById(Integer sid) {
        Student student = studentService.findStudentById(sid);
        JsonResult jsonResult = new JsonResult(0, student);
        return jsonResult;
    }

    @RequestMapping("/modify.do")
    public String modify(Integer id, Model model){
        Student student = studentService.findStudentById(id);
        model.addAttribute("student",student);
        return "after/modifyStudent";
    }

    @RequestMapping("/modifyStudent.do")
    @ResponseBody
    public JsonResult modifyStudent(Student student) {
        studentService.modifyStudent(student);
        JsonResult jsonResult = new JsonResult(0,null);
        return jsonResult;
    }

    @RequestMapping("/deleteStudent.do")
    @ResponseBody
    public JsonResult deleteStudent(Integer sid){
        studentService.deleteStudent(sid);
        JsonResult jsonResult = new JsonResult(0,null);
        return jsonResult;
    }

    @ResponseBody
    @RequestMapping("/deleteMany.do")
    public JsonResult deleteMany(Integer[] sids){
        studentService.deleteMany(sids);
        JsonResult jsonResult = new JsonResult(0,null);
        return jsonResult;
    }
}
