package hu.unideb.thesis.models.requests;

import java.util.List;

public class QuestionRequest {
    private String question;
    private List<AnswerRequest> answers;
    private Integer testId;

    public QuestionRequest() {
    }

    public QuestionRequest(String question, List<AnswerRequest> answers, Integer testId) {
        this.question = question;
        this.answers = answers;
        this.testId = testId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<AnswerRequest> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerRequest> answers) {
        this.answers = answers;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }
}
