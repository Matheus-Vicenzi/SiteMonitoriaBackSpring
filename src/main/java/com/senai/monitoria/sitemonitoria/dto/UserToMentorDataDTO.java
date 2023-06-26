package com.senai.monitoria.sitemonitoria.dto;

import com.senai.monitoria.sitemonitoria.entities.SecurityLevel;
import com.senai.monitoria.sitemonitoria.entities.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

@Getter
@Data
@AllArgsConstructor
public class UserToMentorDataDTO {

    private GregorianCalendar startMentoringDate;
    private GregorianCalendar endMentoringDate;
    private Set<Subject> mentoringSubjects;
}
