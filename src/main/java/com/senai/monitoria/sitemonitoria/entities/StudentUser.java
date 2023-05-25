package com.senai.monitoria.sitemonitoria.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_student")
public class StudentUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;
    @OneToMany(mappedBy = "student")
    private List<MentoringEvent> mentorEventHistory;
    @ManyToOne
    private Course course;
    private int CurrentSemester;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
