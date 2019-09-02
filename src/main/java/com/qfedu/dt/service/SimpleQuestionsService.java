package com.qfedu.dt.service;




import com.qfedu.dt.vo.Simple;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SimpleQuestionsService {


    //查找所有的简单题
    public List<Simple> findAllSimple(Integer page, Integer limit, String keyWord, Integer courseId, String level);
    //删除简答题
    public void deleteOneSimple(Integer id);
    //批量删除
    public void deleteAllSimple(Integer[] id);

}
