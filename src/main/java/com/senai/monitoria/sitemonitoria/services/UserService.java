package com.senai.monitoria.sitemonitoria.services;

import com.senai.monitoria.sitemonitoria.dto.UserDTO;
import com.senai.monitoria.sitemonitoria.dto.UserToMentorDataDTO;
import com.senai.monitoria.sitemonitoria.entities.SecurityLevel;
import com.senai.monitoria.sitemonitoria.entities.User;
import com.senai.monitoria.sitemonitoria.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAll() {
        List<User> allUsersList = userRepository.findAll();
        return allUsersList.stream().map(UserDTO::new).toList();
    }

    public void save(UserDTO userDTO) {
        User userToSave = userDTO.dtoToUser();
        userRepository.save(userToSave);
    }

    public UserDTO findById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return new UserDTO(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public void update(UserDTO userDTO, Long id) {
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

    public void userToMentor(Long id, UserToMentorDataDTO userToMentorDataDTO) {
        userRepository.findById(id).map(user -> {
            user.setSecurityLevel(SecurityLevel.MENTOR);
            user.setStartMentoringDate(userToMentorDataDTO.getStartMentoringDate());
            user.setEndMentoringDate(userToMentorDataDTO.getEndMentoringDate());
            user.setMentoringSubjects(userToMentorDataDTO.getMentoringSubjects());
            userRepository.save(user);
            return user;
        });
    }

    public void userToAdmin(long id) {
        userRepository.findById(id).map(user -> {
            user.setSecurityLevel(SecurityLevel.ADMINISTRATOR);
            userRepository.save(user);
            return user;
        });
    }

    public void userToStudent(long id) {
        userRepository.findById(id).map(user -> {
            user.setSecurityLevel(SecurityLevel.STUDENT);
            userRepository.save(user);
            return user;
        });
    }
}
