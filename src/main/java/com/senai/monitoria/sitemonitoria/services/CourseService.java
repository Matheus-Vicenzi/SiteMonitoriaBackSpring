package com.senai.monitoria.sitemonitoria.services;

import com.senai.monitoria.sitemonitoria.dto.ChangeCourseNameDTO;
import com.senai.monitoria.sitemonitoria.dto.ConsultCourseDTO;
import com.senai.monitoria.sitemonitoria.dto.CourseDTO;
import com.senai.monitoria.sitemonitoria.entities.Course;
import com.senai.monitoria.sitemonitoria.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public void save(CourseDTO courseDTO) {
        Course course = courseDTO.dtoToObject();
        courseRepository.save(course);
    }

    public CourseDTO findById(UUID id) {
        Course course = courseRepository.findById(id).orElseThrow();
        return new CourseDTO(course);
    }

    public List<ConsultCourseDTO> findAll() {
        return courseRepository.findAll().stream().map(ConsultCourseDTO::new).toList();
    }

    public void save (ChangeCourseNameDTO courseDTO){
        Course course = courseRepository.findById(courseDTO.getId()).orElseThrow();
        course.setName(course.getName());
        courseRepository.save(course);
    }
}
