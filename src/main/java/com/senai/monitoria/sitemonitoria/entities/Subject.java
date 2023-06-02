package com.senai.monitoria.sitemonitoria.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_subject")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private long subjectId;
    private String subjectName;
    @ManyToMany(mappedBy = "mentoringSubjects")
    private List<User> mentors;
}
