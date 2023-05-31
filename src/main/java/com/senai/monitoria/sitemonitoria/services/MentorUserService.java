package com.senai.monitoria.sitemonitoria.services;

import com.senai.monitoria.sitemonitoria.dto.MentorUserDTO;
import com.senai.monitoria.sitemonitoria.entities.MentorUser;
import com.senai.monitoria.sitemonitoria.repositories.MentorUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentorUserService {

    @Autowired
    private MentorUserRepository mentorUserRepository;

    public List<MentorUserDTO> findAll(){
        List<MentorUser> mentors = mentorUserRepository.findAll();
        return mentors.stream().map(MentorUserDTO::new).toList();
    }

    public MentorUserDTO save(MentorUserDTO mentorUserDTO){
        MentorUser mentorUserToSave = new MentorUser(mentorUserDTO);
        MentorUser savedMentorUser = mentorUserRepository.save(mentorUserToSave);
        return new MentorUserDTO(savedMentorUser);
    }
}
