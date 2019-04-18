package hu.unideb.thesis.models.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnswerRequest {
    private String answer;
    @JsonProperty
    private Boolean isRight;

    public AnswerRequest() {
    }

    public AnswerRequest(String answer) {
        this(answer, false);
    }

    public AnswerRequest(String answer, Boolean isRightAnswer) {
        this.answer = answer;
        this.isRight = isRightAnswer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getRightAnswer() {
        return isRight;
    }

    public void setRightAnswer(Boolean rightAnswer) {
        isRight = rightAnswer;
    }
}
