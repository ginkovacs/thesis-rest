package hu.unideb.thesis.models.requests;

import java.util.List;

public class TestRequest {
    private String name;
    private List<QuestionRequest> questions;
    private Integer courseId;

    public TestRequest() {
    }

    public TestRequest(String name, List<QuestionRequest> questions, Integer courseId) {
        this.name = name;
        this.questions = questions;
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<QuestionRequest> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionRequest> questions) {
        this.questions = questions;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}
