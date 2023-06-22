package com.senai.monitoria.sitemonitoria.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_course")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Course {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String courseName;
    @ManyToMany(targetEntity = Subject.class)
    @JoinTable(name = "tb_course_subject",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Set<Subject> subjects;

    public Course(UUID id, String courseName) {
        this.id = id;
        this.courseName = courseName;
    }

}
