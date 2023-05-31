package com.senai.monitoria.sitemonitoria.services;

import com.senai.monitoria.sitemonitoria.dto.UserDTO;
import com.senai.monitoria.sitemonitoria.entities.User;
import com.senai.monitoria.sitemonitoria.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAll(){
        List<User> allUsersList = userRepository.findAll();
        return allUsersList.stream().map(UserDTO::new).toList();
    }

    public void save(UserDTO userDTO){
        User userToSave = userDTO.dtoToUser();
        User savedUser = userRepository.save(userToSave);
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

}
