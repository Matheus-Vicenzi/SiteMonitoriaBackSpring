package com.senai.monitoria.sitemonitoria.dto;

import com.senai.monitoria.sitemonitoria.entities.Course;
import com.senai.monitoria.sitemonitoria.entities.Subject;
import com.senai.monitoria.sitemonitoria.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
@Getter
public class ConsultSubjectDTO {
    private UUID id;
    private String name;
    private Set<UUID> usersId;
    private Set<UUID> coursesId;

    public ConsultSubjectDTO(Subject subject){
        this.id = subject.getId();
        this.name = subject.getName();
        this.usersId = subject.getMentors().stream().map(User::getId).collect(Collectors.toSet());
        this.coursesId = subject.getCourses().stream().map(Course::getId).collect(Collectors.toSet());
    }

}
