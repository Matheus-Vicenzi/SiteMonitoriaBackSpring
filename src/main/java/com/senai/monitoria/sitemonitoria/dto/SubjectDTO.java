package com.senai.monitoria.sitemonitoria.dto;


import com.senai.monitoria.sitemonitoria.entities.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Data
public class SubjectDTO {
    private UUID id;
    private String name;
    private List<UserDTO> mentors;

    public SubjectDTO(Subject subject) {
        id = subject.getId();
        name = subject.getName();
        mentors = subject.getMentors().stream().map(UserDTO::new).toList();
    }

    public Subject dtoToSubject(){
        return new Subject(id, name, new HashSet<>(), new HashSet<>());
    }

}
