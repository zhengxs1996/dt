package com.qfedu.dt.entity;

public class SimpleQuestions {
    private Integer saqId;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    private String courseId;
    private String question;
    private String answer;
    private  String level;

    public Integer getSaqId() {
        return saqId;
    }

    public void setSaqId(Integer saqId) {
        this.saqId = saqId;
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
