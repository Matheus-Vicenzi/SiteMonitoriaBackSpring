package com.senai.monitoria.sitemonitoria.services;

import com.senai.monitoria.sitemonitoria.dto.UserDTO;
import com.senai.monitoria.sitemonitoria.entities.User;
import com.senai.monitoria.sitemonitoria.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserDTO> findAll(){
        List<User> allUsersList = userRepository.findAll();
        return allUsersList.stream().map(user -> new UserDTO(user)).toList();
    }

    public UserDTO save(UserDTO userDTO){
        User userToSave = new User(userDTO);
        User savedUser = userRepository.save(userToSave);
        return new UserDTO(savedUser);
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return new UserDTO(user);
    }
}
