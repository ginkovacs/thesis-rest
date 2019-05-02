package hu.unideb.thesis.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Files {

    @Id
    @GeneratedValue
    private Integer fileId;

    private String fileName;
    private String linkToServer;
    private String type;

    @ManyToOne
    @JoinColumn(name = "courseId")
    @JsonIgnore
    private Course course;

    @ManyToOne
    @JoinColumn(name = "questionId")
    @JsonIgnore
    private Question question;

    public Files() {
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getLinkToServer() {
        return linkToServer;
    }

    public void setLinkToServer(String linkToServer) {
        this.linkToServer = linkToServer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
