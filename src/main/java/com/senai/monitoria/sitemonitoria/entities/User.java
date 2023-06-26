package com.senai.monitoria.sitemonitoria.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.GregorianCalendar;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "user_name", nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(name = "user_password", nullable = false)
    private String password;
    @ColumnDefault("2")
    @Column(nullable = false)
    private SecurityLevel securityLevel;
    @Column(nullable = false)
    private String phone;
    @ColumnDefault("true")
    @Column(nullable = false)
    private boolean isActive;
    @ManyToMany(targetEntity = Subject.class)
    private Set<Subject> mentoringSubjects;
    @ManyToOne
    private Course course;
    @ColumnDefault("null")
    private GregorianCalendar startMentoringDate;
    @ColumnDefault("null")
    private GregorianCalendar endMentoringDate;

    public User(UUID id, String name, String email, String password, SecurityLevel securityLevel, String phone, boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.securityLevel = securityLevel;
        this.phone = phone;
        this.isActive = isActive;
        this.mentoringSubjects = null;
        this.course = null;
        this.startMentoringDate = null;
        this.endMentoringDate = null;
    }

    public User(UUID id, String name, String email, SecurityLevel securityLevel, String phone, boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.securityLevel = securityLevel;
        this.phone = phone;
        this.isActive = isActive;
    }
}
