package com.senai.monitoria.sitemonitoria.dto;

import com.senai.monitoria.sitemonitoria.entities.SecurityLevel;
import com.senai.monitoria.sitemonitoria.entities.User;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class LoginResponseDTO {
    private boolean isValid;
    private SecurityLevel securityLevel;

    public LoginResponseDTO(User user){
        isValid = true;
        securityLevel = user.getSecurityLevel();
    }
}
