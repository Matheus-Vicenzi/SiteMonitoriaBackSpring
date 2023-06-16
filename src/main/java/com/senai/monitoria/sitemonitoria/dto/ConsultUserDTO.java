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
public class ConsultUserDTO {
    private UUID id;
    private String name;
    private String email;
    private SecurityLevel securityLevel;
    private String phone;
    private boolean isActive;

    public ConsultUserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.securityLevel = user.getSecurityLevel();
        this.phone = user.getPhone();
        this.isActive = user.isActive();
    }

    public User dtoToUser() {
        return new User(id, name, email, securityLevel, phone, isActive);
    }
}
