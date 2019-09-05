package com.qfedu.dt.controller;

import com.qfedu.dt.dao.ScoreMamagerDao;
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
public class ScoreManagerCotroller {
    @Autowired(required = false)
    private ScoreMamagerDao scoreMamagerDao;

    @RequestMapping("/toScoreList")
    public String toExamManage() {
        return "after/score";
    }

    @ResponseBody
    @RequestMapping("/scoreJudgment.do")
    public Map<String, Object> scoreJudgment(Integer eid, Model model){
            Map<String, Object> map = new HashMap<>();
            List<String> name = scoreMamagerDao.selectAllStudentName(eid);
            List<Integer> score = scoreMamagerDao.selectAllScore(eid);
            if(name.size() == 0){
                map.put("code",0);
                map.put("info","本场考试还没有成绩" );
            } else{
                map.put("code",1);
                map.put("info",null );
            }

            return map;

        }




    @RequestMapping("/score.do")
    public String add(Integer eid, Model model){
        model.addAttribute("eid",eid);
        return "after/ScoreManager.html";

    }




    @ResponseBody
    @RequestMapping("/findAllScore.do")
    public Map<String, Object> selectScore(Integer eid){
        Map<String, Object> map = new HashMap<>();
        List<String> name = scoreMamagerDao.selectAllStudentName(eid);
        List<Integer> score = scoreMamagerDao.selectAllScore(eid);
        if(name.size() != 0){
            map.put("info","");
            map.put("code",0);
            map.put("info",null);
            map.put("name",name);
            map.put("score", score);
        } else{
            map.put("code",1);
            map.put("info","本场考试还没有批改" );
        }


        return map;

    }


    @ResponseBody
    @RequestMapping("/before/findOneScore.do")
    public Map<String, Object> selectOneScore(String email){
        int sid = scoreMamagerDao.findIdByEmail(email);
        Map<String, Object> map = new HashMap<>();
        List<String> data = scoreMamagerDao.selectAllStudentExam(sid);
        List<Integer> score = scoreMamagerDao.selectOneAllScore(sid);
        if(data.size() != 0){
            map.put("info","");
            map.put("code",0);
            map.put("info",null);
            map.put("data",data);
            map.put("score", score);
        } else{
            map.put("code",1);
            map.put("info","本场考试还没有批改" );
        }


        return map;

    }





}
