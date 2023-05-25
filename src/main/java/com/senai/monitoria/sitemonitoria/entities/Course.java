package com.senai.monitoria.sitemonitoria.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long courseId;
    private String courseName;
    @ManyToMany(targetEntity = Subject.class, cascade = CascadeType.ALL)
    @JoinTable(name = "course_subject",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> subjects;

    public Course() {
    }

    public Course(long courseId, String courseName, List<Subject> subjects) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.subjects = subjects;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
