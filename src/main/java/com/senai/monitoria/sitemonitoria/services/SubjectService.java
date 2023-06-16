package com.senai.monitoria.sitemonitoria.services;

import com.senai.monitoria.sitemonitoria.dto.SubjectDTO;
import com.senai.monitoria.sitemonitoria.entities.Subject;
import com.senai.monitoria.sitemonitoria.entities.User;
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

    public List<SubjectDTO> findAll() {
        List<Subject> allSubjectsList = subjectRepository.findAll();
        return allSubjectsList.stream().map(SubjectDTO::new).toList();
    }

    public void save(SubjectDTO subjectDTO) {
        Subject subject = subjectDTO.dtoToSubject();
        subjectRepository.save(subject);
    }

    public void addMentorToSubject(UUID mentorId, UUID subjectId) {
        User mentor = userService.findById(mentorId).dtoToUser();
        Subject subject = subjectRepository.findById(subjectId).orElseThrow();
        subject.getMentors().add(mentor);
        subjectRepository.save(subject);
    }

    public void delete(UUID id) {
        subjectRepository.deleteById(id);
    }
}
