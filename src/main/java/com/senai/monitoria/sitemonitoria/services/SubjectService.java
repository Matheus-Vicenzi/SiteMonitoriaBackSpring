package com.senai.monitoria.sitemonitoria.services;

import com.senai.monitoria.sitemonitoria.dto.ConsultSubjectDTO;
import com.senai.monitoria.sitemonitoria.dto.SaveSubjectDTO;
import com.senai.monitoria.sitemonitoria.dto.SubjectDTO;
import com.senai.monitoria.sitemonitoria.entities.Course;
import com.senai.monitoria.sitemonitoria.entities.Subject;
import com.senai.monitoria.sitemonitoria.entities.User;
import com.senai.monitoria.sitemonitoria.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private CourseService courseService;

    public List<ConsultSubjectDTO> findAll() {
        List<Subject> allSubjectsList = subjectRepository.findAll();
        return allSubjectsList.stream().map(ConsultSubjectDTO::new).toList();
    }

    public void save(SaveSubjectDTO saveSubjectDTO) {
        Set<Course> courses = saveSubjectDTO.getCoursesId().stream().map(courseId ->
                courseService.findById(courseId).dtoToObject()).collect(Collectors.toSet());
        Subject subject = new Subject();
        subject.setName(saveSubjectDTO.getSubjectName());
        subject.setMentors(new HashSet<>());
        subject.setCourses(courses);
        subjectRepository.save(subject);
    }

    public void addMentorToSubject(UUID mentorId, UUID subjectId) {
        User mentor = userService.findById(mentorId).dtoToObject();
        Subject subject = subjectRepository.findById(subjectId).orElseThrow();
        subject.getMentors().add(mentor);
        subjectRepository.save(subject);
    }

    public void delete(UUID id) {
        subjectRepository.deleteById(id);
    }
}
