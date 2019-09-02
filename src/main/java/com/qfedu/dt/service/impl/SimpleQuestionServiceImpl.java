package com.qfedu.dt.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.qfedu.dt.dao.JudgmentQuestionsDao;
import com.qfedu.dt.dao.SimpleQuestionsDao;
import com.qfedu.dt.entity.JudgmentQuestions;
import com.qfedu.dt.entity.SimpleQuestions;
import com.qfedu.dt.service.JudgmentQuestionService;
import com.qfedu.dt.service.SimpleQuestionsService;
import com.qfedu.dt.untils.ExcelUtils;
import com.qfedu.dt.vo.Judgment;
import com.qfedu.dt.vo.Simple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Service
public class SimpleQuestionServiceImpl implements SimpleQuestionsService {

    @Autowired(required = false)
    private SimpleQuestionsDao simpleQuestionsDao;

    //展示所有的简答题
    @Override
    public List<Simple> findAllSimple(Integer page, Integer limit, String keyWord, Integer courseId, String level) {
        PageHelper.startPage(page, limit);
        List<Simple> list = simpleQuestionsDao.findAllSimple(keyWord, courseId, level);
        while(true){
            if (list.size() != 0) {
                break;
            }
            PageHelper.startPage(--page, limit);
            list = simpleQuestionsDao.findAllSimple(keyWord, courseId, level);
        }
        return list;
    }



    //删除一道简答题
    @Override
    public void deleteOneSimple(Integer id) {
        simpleQuestionsDao.deleteOneSimple(id);

    }

    //批量删除判断题
    @Override
    public void deleteAllSimple(Integer[] id) {
        simpleQuestionsDao.deleteAllSimple(id);


    }

    @Override
    public void uploadSimple(MultipartFile upfile) {
        try {
            InputStream inputStream = upfile.getInputStream();

            //文件名
            String originalFilename = upfile.getOriginalFilename();

            List<Map<String, Object>> list = ExcelUtils.readExcel(inputStream, originalFilename);

            ObjectMapper objectMapper = new ObjectMapper();
            //将List转成json格式数据
            String jsonStr = objectMapper.writeValueAsString(list);
            //将json格式数据转成指定对象
            List<SimpleQuestions> sqList = objectMapper.readValue(jsonStr, new TypeReference<List<SimpleQuestions>>(){
            });

            //将选择题对象集合存入数据库
            simpleQuestionsDao.addAll(sqList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
