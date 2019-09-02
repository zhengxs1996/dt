package com.qfedu.dt.service;

import com.qfedu.dt.entity.Course;
import com.qfedu.dt.entity.JudgmentQuestions;
import com.qfedu.dt.vo.Judgment;
import com.qfedu.dt.vo.Selects;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;



public interface JudgmentQuestionService {



    //查找所有的判断题
    public List<Judgment> findAllJudgment(Integer page, Integer limit, String keyWord, Integer courseId, String level);

    //删除判断题
    public void deleteOneJudgment(Integer id);
    //批量删除
    public void deleteAllJudgment(Integer[] id);

    public void uploadJudgment(MultipartFile file);

}
