package com.qfedu.dt.controller;

import com.github.pagehelper.Page;
import com.qfedu.dt.common.JsonResult;
import com.qfedu.dt.service.ApplyService;
import com.qfedu.dt.vo.ExamInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: dt
 * @description: 报名Controller
 * @author: sjm
 * @create: 2019-09-02 14:27
 **/
@Controller
@RequestMapping("/before/apply")
public class ApplyController {
    @Autowired
    private ApplyService applyService;

    @ResponseBody
    @RequestMapping("/findAllExam.do")
    public Map<String,Object> findAllExam(Integer page, Integer limit){
        List<ExamInfo> allExam = applyService.findAllExam(page,limit);
        long total = ((Page) allExam).getTotal();
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",allExam);
        return map;
    }

    @ResponseBody
    @RequestMapping("/applyExam.do")
    public JsonResult applyExam(Integer eId, HttpServletRequest request){
        Integer sId = Integer.parseInt( request.getHeader("sId"));
        Integer statue = applyService.applyExam(sId, eId);
        if (statue == 0){
            return new JsonResult(0,"报名成功");
        }else {
            return new JsonResult(1,"已报名，请勿重复报名");
        }
    }
}