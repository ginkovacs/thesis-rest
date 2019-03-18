package hu.unideb.thesis.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue
    private Integer id;
    private String answer;
    private Boolean isRight;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "questionId")
    @JsonBackReference
    private Question question;

    public Answer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getRight() {
        return isRight;
    }

    public void setRight(Boolean right) {
        isRight = right;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                ", question=" + question +
                '}';
    }
}
