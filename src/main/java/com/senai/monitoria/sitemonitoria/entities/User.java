package com.senai.monitoria.sitemonitoria.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.GregorianCalendar;
import java.util.List;

@Entity
@Table(name = "tb_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "user_name")
    private String name;
    @Column(unique = true)
    private String email;
    @Column(name = "user_password")
    private String password;
    @ColumnDefault("2")
    private SecurityLevel securityLevel;
    private String phone;
    @ColumnDefault("true")
    private boolean isActive;
    @ManyToMany(targetEntity = Subject.class)
    private List<Subject> mentoringSubjects;
    @ManyToOne
    private Course course;
    @ColumnDefault("null")
    private GregorianCalendar startMentoringDate;
    private GregorianCalendar endMentoringDate;

    public User(long id, String name, String email, String password, SecurityLevel securityLevel, String phone, boolean isActive) {
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
}
