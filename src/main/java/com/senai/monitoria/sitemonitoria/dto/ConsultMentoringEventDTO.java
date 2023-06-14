package com.senai.monitoria.sitemonitoria.dto;

import com.senai.monitoria.sitemonitoria.entities.MentoringEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.GregorianCalendar;

@Getter
@Data
@AllArgsConstructor
public class ConsultMentoringEventDTO {
    private UserDTO mentorDTO;
    private UserDTO studentDTO;
    private GregorianCalendar requestDate;
    private GregorianCalendar scheduleDate;
    private String studentDescription;
    private String mentorDescription;
    private String mentoringEventStatus;

    public ConsultMentoringEventDTO(MentoringEvent mentoringEvent){
        this.mentorDTO = new UserDTO(mentoringEvent.getMentor());
        this.studentDTO = new UserDTO(mentoringEvent.getStudent());
        this.requestDate = mentoringEvent.getRequestDate();
        this.scheduleDate = mentoringEvent.getScheduleDate();
        this.studentDescription = mentoringEvent.getStudentDescription();
        this.mentorDescription = mentoringEvent.getMentorDescription();
    }
}
