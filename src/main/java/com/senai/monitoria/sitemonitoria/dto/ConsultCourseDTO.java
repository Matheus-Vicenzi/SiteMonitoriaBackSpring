package com.senai.monitoria.sitemonitoria.dto;

import com.senai.monitoria.sitemonitoria.entities.Course;
import com.senai.monitoria.sitemonitoria.entities.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@Data
public class ConsultCourseDTO implements DTOInterface{
    private UUID id;
    private String name;
    private Set<UUID> subjectsId;

    public ConsultCourseDTO(Course course){
        this.id = course.getId();
        this.name = course.getCourseName();
        this.subjectsId = course.getSubjects().stream().map(Subject::getId).collect(Collectors.toSet());
    }

    @Override
    public Object dtoToObject() {
        throw new RuntimeException("Not implemented");
    }
}
