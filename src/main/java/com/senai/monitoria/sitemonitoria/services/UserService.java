package com.senai.monitoria.sitemonitoria.services;

import com.senai.monitoria.sitemonitoria.dto.ConsultUserDTO;
import com.senai.monitoria.sitemonitoria.dto.UserDTO;
import com.senai.monitoria.sitemonitoria.dto.UserToMentorDataDTO;
import com.senai.monitoria.sitemonitoria.entities.SecurityLevel;
import com.senai.monitoria.sitemonitoria.entities.User;
import com.senai.monitoria.sitemonitoria.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAll() {
        List<User> allUsersList = userRepository.findAll();
        return allUsersList.stream().map(UserDTO::new).toList();
    }

    public void save(UserDTO userDTO) {
        User userToSave = userDTO.dtoToObject();
        userRepository.save(userToSave);
    }

    public ConsultUserDTO findById(UUID id) {
        User user = userRepository.findById(id).orElseThrow();
        return new ConsultUserDTO(user);
    }

    public void deactivate(UUID id) {
        User user = userRepository.findById(id).orElseThrow();
        user.setActive(false);
        userRepository.save(user);
    }

    public void update(UserDTO userDTO, UUID id) {
        userRepository.findById(id).map(user -> {
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setSecurityLevel(userDTO.getSecurityLevel());
            user.setPhone(userDTO.getPhone());
            user.setActive(userDTO.isActive());
            User updatedUser = userRepository.save(user);
            return new UserDTO(updatedUser);
        }).orElseThrow();
    }

    public void userToMentor(UUID id, UserToMentorDataDTO userToMentorDataDTO) {
        userRepository.findById(id).map(user -> {
            user.setSecurityLevel(SecurityLevel.MENTOR);
            user.setStartMentoringDate(userToMentorDataDTO.getStartMentoringDate());
            user.setEndMentoringDate(userToMentorDataDTO.getEndMentoringDate());
            user.setMentoringSubjects(userToMentorDataDTO.getMentoringSubjects());
            userRepository.save(user);
            return user;
        });
    }

    public void userToAdmin(UUID id) {
        userRepository.findById(id).map(user -> {
            user.setSecurityLevel(SecurityLevel.ADMINISTRATOR);
            userRepository.save(user);
            return user;
        });
    }

    public void userToStudent(UUID id) {
        userRepository.findById(id).map(user -> {
            user.setSecurityLevel(SecurityLevel.STUDENT);
            userRepository.save(user);
            return user;
        });
    }

    public List<UserDTO> findActiveUsers() {
        return userRepository.findActiveUsers().stream().map(UserDTO::new).toList();
    }
}
