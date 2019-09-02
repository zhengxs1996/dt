package com.qfedu.dt.entity;

/**
 * 判断题实体类
 */
public class JudgmentQuestions {
    private Integer yId;
    private String courseld;
    private String question;
    private String answer;
    private String level;

    public Integer getyId() {
        return yId;
    }

    public void setyId(Integer yId) {
        this.yId = yId;
    }

    public String getCourseld() {
        return courseld;
    }

    public void setCourseld(String courseld) {
        this.courseld = courseld;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
