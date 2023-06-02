package com.senai.monitoria.sitemonitoria.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.GregorianCalendar;

@Entity
@Table(name = "tb_mentoring_event")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class MentoringEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mentoringEventId;
    @ManyToOne
    private User mentor;
    @ManyToOne
    private User student;
    private GregorianCalendar requestDate;
    private GregorianCalendar scheduleDate;
    @ManyToOne
    private Course course;
    private String studentDescription;
    private String mentorDescription;
    private MentoringEventStatus mentoringEventStatus;
}
