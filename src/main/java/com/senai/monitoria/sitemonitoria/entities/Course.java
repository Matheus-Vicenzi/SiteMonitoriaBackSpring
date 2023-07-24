package com.senai.monitoria.sitemonitoria.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "tb_course")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = "subjects")
public class Course {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(unique = true)
    private String name;
    @ManyToMany(targetEntity = Subject.class)
    private Set<Subject> subjects = new HashSet<>();

    public void addSubject(Subject subject) {
        if (subject == null) {
            throw new NullPointerException("Subject is null");
        }
        if (subjects == null) {
            subjects = new HashSet<>();
        }
        subjects.add(subject);
        subject.getCourses().add(this);
    }

}
