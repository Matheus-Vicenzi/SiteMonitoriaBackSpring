package com.senai.monitoria.sitemonitoria.services;

import com.senai.monitoria.sitemonitoria.dto.LoginDTO;
import com.senai.monitoria.sitemonitoria.dto.LoginResponseDTO;
import com.senai.monitoria.sitemonitoria.dto.UserDTO;
import com.senai.monitoria.sitemonitoria.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginService {
    @Autowired
    private UserService userService;
    public LoginResponseDTO validateLogin(LoginDTO loginDTO) {

        UserDTO userDTO = userService.findByEmail(loginDTO.getEmail());
        if(userDTO == null){
            return new LoginResponseDTO(false, null);
        }
        String passwordHash = SecurityUtils.encrypt(loginDTO.getPassword());
        boolean isValid = SecurityUtils.checkPassword(loginDTO.getPassword(), passwordHash);
        if (!isValid) {
            return new LoginResponseDTO(false, null);
        }
        return new LoginResponseDTO(userDTO.dtoToObject());
    }
}