package com.senai.monitoria.sitemonitoria.dto;

import com.senai.monitoria.sitemonitoria.entities.MentorUser;
import com.senai.monitoria.sitemonitoria.entities.MentoringEvent;
import com.senai.monitoria.sitemonitoria.entities.Subject;
import com.senai.monitoria.sitemonitoria.entities.User;

import java.util.GregorianCalendar;
import java.util.List;

public class MentorUserDTO {
    private long mentorId;
    private List<MentoringEvent> mentorEvents;
    private List<Subject> subjects;
    private GregorianCalendar mentoringStartDate;
    private GregorianCalendar mentoringFinishDate;
    private User user;

    public MentorUserDTO(MentorUser mentorUser) {
        mentorId = mentorUser.getMentorId();
        mentorEvents = mentorUser.getMentorEventHistory();
        subjects = mentorUser.getSubjects();
        mentoringStartDate = mentorUser.getMentoringStartDate();
        mentoringFinishDate = mentorUser.getMentoringFinishDate();
        user = mentorUser.getUser();
    }

    public MentorUserDTO(long mentorId, List<MentoringEvent> mentorEvents, List<Subject> subjects,
                         GregorianCalendar mentoringStartDate, GregorianCalendar mentoringFinishDate, User user) {
        this.mentorId = mentorId;
        this.mentorEvents = mentorEvents;
        this.subjects = subjects;
        this.mentoringStartDate = mentoringStartDate;
        this.mentoringFinishDate = mentoringFinishDate;
        this.user = user;
    }

    public long getMentorId() {
        return mentorId;
    }

    public List<MentoringEvent> getMentorEvents() {
        return mentorEvents;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public GregorianCalendar getMentoringStartDate() {
        return mentoringStartDate;
    }

    public GregorianCalendar getMentoringFinishDate() {
        return mentoringFinishDate;
    }

    public User getUser() {
        return user;
    }
}
