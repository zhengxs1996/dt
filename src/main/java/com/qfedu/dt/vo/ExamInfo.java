package com.qfedu.dt.vo;

import lombok.Data;

import java.util.Date;

/**
 * @program: dt
 * @description: 考试信息
 * @author: sjm
 * @create: 2019-09-02 14:30
 **/

public class ExamInfo {
    private Integer eId; //考试id
    private Integer courseId; //学科Id
    private String cName; //学科名字
    private Date beginTime;
    private Date endTime;
    private int totalTime;

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }
}
