package com.qfedu.dt.service;

import com.qfedu.dt.entity.Course;
import com.qfedu.dt.vo.Selects;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface QuestionService {

    public List<Selects> selectList(Integer page, Integer limit, String keyWord, Integer courseId, String level);

    public List<Course> findAllCourse();

    public void deleteOneSelect(Integer id);

    public void deleteAllSelect(Integer[] id);

    public void uploadSelect(MultipartFile file);

}
