package hu.unideb.thesis.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Links {
    @Id
    @GeneratedValue
    private Integer linkId;

    private String link;

    @ManyToOne
    @JoinColumn(name = "courseId")
    @JsonBackReference
    private Course course;

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
