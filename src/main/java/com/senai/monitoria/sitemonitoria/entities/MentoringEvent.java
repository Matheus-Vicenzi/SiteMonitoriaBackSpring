package com.senai.monitoria.sitemonitoria.entities;

import jakarta.persistence.*;

import java.util.GregorianCalendar;

@Entity
@Table(name = "tb_mentoring_event")
public class MentoringEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mentoringEventId;
    @ManyToOne
    private MentorUser mentor;
    @ManyToOne
    private StudentUser student;
    private GregorianCalendar requestDate;
    private GregorianCalendar scheduleDate;
    @ManyToOne
    private Course course;
    private String studentDescription;
    private String mentorDescription;
    private MentoringEventStatus mentoringEventStatus;
}
