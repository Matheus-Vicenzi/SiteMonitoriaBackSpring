package com.senai.monitoria.sitemonitoria.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private long subjectId;
    private String subjectName;
    @ManyToMany(mappedBy = "subjects")
    private List<MentorUser> mentors;
}
