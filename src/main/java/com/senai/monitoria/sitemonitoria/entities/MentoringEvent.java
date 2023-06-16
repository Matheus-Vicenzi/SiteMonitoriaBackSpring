package com.senai.monitoria.sitemonitoria.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.GregorianCalendar;
import java.util.UUID;

@Entity
@Table(name = "tb_mentoring_event")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class MentoringEvent {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID mentoringEventId;
    @ManyToOne
    private User mentor;
    @ManyToOne
    private User student;
    @Column(nullable = false)
    private GregorianCalendar requestDate;
    @Column(nullable = false)
    private GregorianCalendar scheduleDate;
    @Column(nullable = false)
    private String studentDescription;
    private String mentorDescription;
    private MentoringEventStatus mentoringEventStatus;

    public MentoringEvent(User mentor, User student, GregorianCalendar requestDate, GregorianCalendar scheduleDate, String studentDescription, String mentorDescription) {
        this.mentor = mentor;
        this.student = student;
        this.requestDate = requestDate;
        this.scheduleDate = scheduleDate;
        this.studentDescription = studentDescription;
        this.mentorDescription = mentorDescription;
        this.mentoringEventStatus = MentoringEventStatus.PENDING;
    }
}
