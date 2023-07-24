package com.senai.monitoria.sitemonitoria.factories;

import com.senai.monitoria.sitemonitoria.dto.SaveSubjectDTO;
import com.senai.monitoria.sitemonitoria.entities.Course;
import com.senai.monitoria.sitemonitoria.entities.Subject;


public class SubjectFactory {
    public static Subject createSubject(SaveSubjectDTO saveSubjectDTO) {
        Subject subject = new Subject();
        subject.setName(saveSubjectDTO.getName());
        return subject;
    }
}
