package com.senai.monitoria.sitemonitoria.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "tb_subject")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Subject {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @ManyToMany(targetEntity = User.class)
    private Set<User> mentors;
    @ManyToMany(targetEntity = Course.class)
    @JoinTable(name = "tb_course_subject",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses;
}
