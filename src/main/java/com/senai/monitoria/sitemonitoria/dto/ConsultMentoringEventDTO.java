package com.senai.monitoria.sitemonitoria.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.senai.monitoria.sitemonitoria.entities.MentoringEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.GregorianCalendar;

@Getter
@Data
@AllArgsConstructor
public class ConsultMentoringEventDTO implements DTOInterface{
    @JsonProperty("mentor")
    private ConsultUserDTO mentorDTO;
    @JsonProperty("student")
    private ConsultUserDTO studentDTO;
    private GregorianCalendar requestDate;
    private GregorianCalendar scheduleDate;
    private String studentDescription;
    private String mentorDescription;
    private String mentoringEventStatus;

    public ConsultMentoringEventDTO(MentoringEvent mentoringEvent){
        this.mentorDTO = new ConsultUserDTO(mentoringEvent.getMentor());
        this.studentDTO = new ConsultUserDTO(mentoringEvent.getStudent());
        this.requestDate = mentoringEvent.getRequestDate();
        this.scheduleDate = mentoringEvent.getScheduleDate();
        this.studentDescription = mentoringEvent.getStudentDescription();
        this.mentorDescription = mentoringEvent.getMentorDescription();
    }

    @Override
    public MentoringEvent dtoToObject() {
        return new MentoringEvent(mentorDTO.dtoToUser(), studentDTO.dtoToUser(), requestDate, scheduleDate, studentDescription, mentorDescription);
    }
}
