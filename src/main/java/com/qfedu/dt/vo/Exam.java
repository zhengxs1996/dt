package com.qfedu.dt.vo;

import java.util.List;

/**
 * 试卷实体类
 */
public class Exam {
    private String title;
    private String infos = null;
    private List<Values> values;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfos() {
        return infos;
    }

    public void setInfos(String infos) {
        this.infos = infos;
    }

    public List<Values> getValues() {
        return values;
    }

    public void setValues(List<Values> values) {
        this.values = values;
    }
}
