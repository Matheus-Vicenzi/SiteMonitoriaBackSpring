package com.senai.monitoria.sitemonitoria.dto;

import com.senai.monitoria.sitemonitoria.entities.SecurityLevel;
import com.senai.monitoria.sitemonitoria.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Data
public class UserDTO implements DTOInterface{

    private UUID id;
    private String name;
    private String email;
    private String password;
    private SecurityLevel securityLevel;
    private String phone;
    private boolean isActive;

    public UserDTO(User user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
        password = user.getPassword();
        securityLevel = user.getSecurityLevel();
        phone = user.getPhone();
        isActive = user.isActive();
    }

    @Override
    public User dtoToObject() {
        return new User(id, name, email, password, securityLevel, phone, isActive);
    }
}
