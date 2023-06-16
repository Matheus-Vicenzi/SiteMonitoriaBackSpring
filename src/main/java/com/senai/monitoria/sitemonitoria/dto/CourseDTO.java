package com.senai.monitoria.sitemonitoria.dto;

import com.senai.monitoria.sitemonitoria.entities.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Data
@AllArgsConstructor
public class CourseDTO implements DTOInterface{
    private UUID id;
    private String courseName;
    private Set<SubjectDTO> subjects;

    public CourseDTO(Course course) {
        id = course.getId();
        courseName = course.getCourseName();
        subjects = course.getSubjects().stream().map(SubjectDTO::new).collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public Course dtoToObject() {
        return new Course(id, courseName, new HashSet<>());
    }
}
