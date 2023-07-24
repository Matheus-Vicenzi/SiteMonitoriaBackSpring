package com.senai.monitoria.sitemonitoria.services;

import com.senai.monitoria.sitemonitoria.dto.ConsultSubjectDTO;
import com.senai.monitoria.sitemonitoria.dto.SaveSubjectDTO;
import com.senai.monitoria.sitemonitoria.entities.Subject;
import com.senai.monitoria.sitemonitoria.entities.User;
import com.senai.monitoria.sitemonitoria.manager.CourseSubjectManager;
import com.senai.monitoria.sitemonitoria.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private CourseSubjectManager courseSubjectManager;

    public List<ConsultSubjectDTO> findAll() {
        return subjectRepository.findAll().stream().map(ConsultSubjectDTO::new).toList();
    }

    public void save(SaveSubjectDTO saveSubjectDTO) {
        courseSubjectManager.saveSubject(saveSubjectDTO);
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

    public ConsultSubjectDTO findById(UUID id) {
        Subject subject = subjectRepository.findById(id).orElseThrow();
        return new ConsultSubjectDTO(subject);
    }

}
