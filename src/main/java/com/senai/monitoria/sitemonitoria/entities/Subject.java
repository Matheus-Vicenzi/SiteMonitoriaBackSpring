package com.senai.monitoria.sitemonitoria.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "tb_subject")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"courses", "mentors"})
public class Subject {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true)
    private String name;
    @ManyToMany(targetEntity = User.class)
    private Set<User> mentors = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "tb_course_subject",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses = new HashSet<>();

    public void addCourse(Course course) {
        if (course == null) {
            throw new NullPointerException("Course is null");
        }
        if (courses == null) {
            courses = new HashSet<>();
        }
        courses.add(course);
        course.getSubjects().add(this);
    }

}
