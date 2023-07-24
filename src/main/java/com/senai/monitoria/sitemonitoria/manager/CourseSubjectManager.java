package com.senai.monitoria.sitemonitoria.manager;

import com.senai.monitoria.sitemonitoria.dto.AddSubjectToCourseDTO;
import com.senai.monitoria.sitemonitoria.dto.SaveSubjectDTO;
import com.senai.monitoria.sitemonitoria.entities.Course;
import com.senai.monitoria.sitemonitoria.entities.Subject;
import com.senai.monitoria.sitemonitoria.factories.SubjectFactory;
import com.senai.monitoria.sitemonitoria.repositories.CourseRepository;
import com.senai.monitoria.sitemonitoria.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CourseSubjectManager {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private CourseRepository courseRepository;

    public void addSubjectToCourse(AddSubjectToCourseDTO addSubjectToCourseDTO) {
        Course course = courseRepository.findById(addSubjectToCourseDTO.getCourseId()).orElseThrow();
        course.addSubject(subjectRepository.findById(addSubjectToCourseDTO.getSubjectId()).orElseThrow());
        courseRepository.save(course);
    }

    public void saveSubject(SaveSubjectDTO saveSubjectDTO) {
        Course course = courseRepository.findById(saveSubjectDTO.getCourseId()).orElseThrow();

        Subject subject = SubjectFactory.createSubject(saveSubjectDTO);
        course.addSubject(subject);
        subjectRepository.save(subject);

    }
}
