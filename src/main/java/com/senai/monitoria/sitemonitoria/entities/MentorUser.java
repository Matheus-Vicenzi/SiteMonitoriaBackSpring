package com.senai.monitoria.sitemonitoria.entities;

import com.senai.monitoria.sitemonitoria.dto.MentorUserDTO;
import jakarta.persistence.*;

import java.util.GregorianCalendar;
import java.util.List;

@Entity
@Table(name = "tb_mentor")
public class MentorUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mentorId;
    @OneToMany(mappedBy = "mentor")
    private List<MentoringEvent> mentorEvents;
    @ManyToMany()
    @JoinTable(name = "tb_subject",
            joinColumns = @JoinColumn(name = "mentor_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjects;
    private GregorianCalendar mentoringStartDate;
    private GregorianCalendar mentoringFinishDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public MentorUser(long mentorId, List<MentoringEvent> mentorEvents, List<Subject> subjects, GregorianCalendar mentoringStartDate, GregorianCalendar mentoringFinishDate, User user) {
        this.mentorId = mentorId;
        this.mentorEvents = mentorEvents;
        this.subjects = subjects;
        this.mentoringStartDate = mentoringStartDate;
        this.mentoringFinishDate = mentoringFinishDate;
        this.user = user;
    }

    public MentorUser() {
    }

    public MentorUser(MentorUserDTO mentorUserDTO) {
        mentorId = mentorUserDTO.getMentorId();
        mentorEvents = mentorUserDTO.getMentorEvents();
        subjects = mentorUserDTO.getSubjects();
        mentoringStartDate = mentorUserDTO.getMentoringStartDate();
        mentoringFinishDate = mentorUserDTO.getMentoringFinishDate();
        user = mentorUserDTO.getUser();
    }

    public long getMentorId() {
        return mentorId;
    }

    public void setMentorId(long mentorId) {
        this.mentorId = mentorId;
    }

    public List<MentoringEvent> getMentorEventHistory() {
        return mentorEvents;
    }

    public void setMentorEventHistory(List<MentoringEvent> mentorEventHistory) {
        this.mentorEvents = mentorEventHistory;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public GregorianCalendar getMentoringStartDate() {
        return mentoringStartDate;
    }

    public void setMentoringStartDate(GregorianCalendar mentoringStartDate) {
        this.mentoringStartDate = mentoringStartDate;
    }

    public GregorianCalendar getMentoringFinishDate() {
        return mentoringFinishDate;
    }

    public void setMentoringFinishDate(GregorianCalendar mentoringFinishDate) {
        this.mentoringFinishDate = mentoringFinishDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}