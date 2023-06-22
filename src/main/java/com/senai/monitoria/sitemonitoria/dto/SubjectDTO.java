package com.senai.monitoria.sitemonitoria.dto;


import com.senai.monitoria.sitemonitoria.entities.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@Data
public class SubjectDTO implements DTOInterface{
    private UUID id;
    private String name;
    private Set<UserDTO> mentors;
    private Set<CourseDTO> courses;

    public SubjectDTO(Subject subject) {
        id = subject.getId();
        name = subject.getName();
        mentors = subject
                .getMentors()
                .stream()
                .map(UserDTO::new)
                .collect(Collectors.toCollection(HashSet::new));
        courses = subject.getCourses()
                .stream()
                .map(CourseDTO::new)
                .collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public Object dtoToObject() {
        throw new RuntimeException("Not implemented");
    }
}
