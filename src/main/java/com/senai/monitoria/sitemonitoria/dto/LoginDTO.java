package com.senai.monitoria.sitemonitoria.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class LoginDTO {
    private String email;
    private String password;
}
