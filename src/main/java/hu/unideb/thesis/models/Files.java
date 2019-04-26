package hu.unideb.thesis.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Files {

    @Id
    @GeneratedValue
    private Integer fileId;

    private String fileName;
    private String linkToServer;

    @ManyToOne
    @JoinColumn(name = "courseId")
    @JsonBackReference
    private Course course;

    @ManyToOne
    @JoinColumn(name = "questionId")
    @JsonBackReference
    private Question question;

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
