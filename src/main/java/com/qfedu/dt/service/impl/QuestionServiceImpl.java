package com.qfedu.dt.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.qfedu.dt.dao.SelectQuestionsDao;
import com.qfedu.dt.entity.Course;
import com.qfedu.dt.entity.JudgmentQuestions;
import com.qfedu.dt.entity.SelectQuestions;
import com.qfedu.dt.service.QuestionService;
import com.qfedu.dt.untils.ExcelUtils;
import com.qfedu.dt.vo.Selects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired(required = false)
    private SelectQuestionsDao selectQuestionsDao;

    @Override
    public List<Selects> selectList(Integer page, Integer limit, String keyWord, Integer courseId, String level) {
        PageHelper.startPage(page, limit);
        List<Selects> list = selectQuestionsDao.findAll(keyWord, courseId, level);
        while(true){
            if (list.size() != 0) {
                break;
            }
            PageHelper.startPage(--page, limit);
            list = selectQuestionsDao.findAll(keyWord, courseId, level);
        }
        return list;
    }

    @Override
    public List<Course> findAllCourse() {
        return selectQuestionsDao.findAllCourse();
    }

    @Override
    public void deleteOneSelect(Integer id) {
        selectQuestionsDao.deleteOneSelect(id);
    }

    @Override
    public void deleteAllSelect(Integer[] id) {
        selectQuestionsDao.deleteAllSelect(id);
    }

    @Override
    public void uploadSelect(MultipartFile upfile) {
        try {
            InputStream inputStream = upfile.getInputStream();

            //文件名
            String originalFilename = upfile.getOriginalFilename();

            List<Map<String, Object>> list = ExcelUtils.readExcel(inputStream, originalFilename);

            ObjectMapper objectMapper = new ObjectMapper();
            //将List转成json格式数据
            String jsonStr = objectMapper.writeValueAsString(list);
            //将json格式数据转成指定对象
            List<SelectQuestions> sqList = objectMapper.readValue(jsonStr, new TypeReference<List<SelectQuestions>>(){
            });

            //将选择题对象集合存入数据库
            selectQuestionsDao.addAll(sqList);

//            System.out.println(sqList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
