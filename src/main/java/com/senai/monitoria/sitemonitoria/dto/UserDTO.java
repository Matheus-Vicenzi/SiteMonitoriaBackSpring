package com.senai.monitoria.sitemonitoria.dto;

import com.senai.monitoria.sitemonitoria.entities.SecurityLevel;
import com.senai.monitoria.sitemonitoria.entities.User;

public class UserDTO {

    private long id;
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

    public UserDTO(long id, String name, String email, String password, SecurityLevel securityLevel, String phone, boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.securityLevel = securityLevel;
        this.phone = phone;
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public SecurityLevel getSecurityLevel() {
        return securityLevel;
    }

    public String getPhone() {
        return phone;
    }
}
