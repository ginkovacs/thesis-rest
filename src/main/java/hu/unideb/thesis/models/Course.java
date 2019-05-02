package hu.unideb.thesis.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<Test> tests = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<Files> files = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<Links> links = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "userEmail")
    @JsonBackReference
    private User user;

    @JsonIgnore
    @ManyToMany(mappedBy = "courses")
    @JsonBackReference
    private List<User> users = new ArrayList<>();

    public Course() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    //létrehozó user
    public User getUser() {
        return user;
    }

    //létrehozó user
    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public List<Files> getFiles() {
        return files;
    }

    public void setFiles(List<Files> files) {
        this.files = files;
    }

    public List<Links> getLinks() {
        return links;
    }

    public void setLinks(List<Links> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", tests=" + tests +
                ", user=" + user +
                ", users=" + users +
                '}';
    }
}
