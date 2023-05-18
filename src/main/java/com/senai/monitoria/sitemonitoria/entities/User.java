package com.senai.monitoria.sitemonitoria.entities;

import com.senai.monitoria.sitemonitoria.dto.UserDTO;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.Objects;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    @Column(name = "user_name")
    private String name;
    private String email;
    private String password;
    private SecurityLevel securityLevel;
    private String phone;
    private boolean isActive;

    public User() {
    }

    public User(long id, String name, String email, String password, SecurityLevel securityLevel, String phone,
                boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.securityLevel = securityLevel;
        this.phone = phone;
        this.isActive = isActive;
    }

    public User(UserDTO userDTO) {
        id = userDTO.getId();
        name = userDTO.getName();
        email = userDTO.getEmail();
        password = userDTO.getPassword();
        securityLevel = userDTO.getSecurityLevel();
        phone = userDTO.getPhone();
        isActive = userDTO.isActive();
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SecurityLevel getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(SecurityLevel securityLevel) {
        this.securityLevel = securityLevel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
