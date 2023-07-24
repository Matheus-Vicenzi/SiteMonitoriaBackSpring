package com.senai.monitoria.sitemonitoria.controllers;

import com.senai.monitoria.sitemonitoria.dto.AddSubjectToCourseDTO;
import com.senai.monitoria.sitemonitoria.dto.ConsultCourseDTO;
import com.senai.monitoria.sitemonitoria.dto.CourseDTO;
import com.senai.monitoria.sitemonitoria.dto.ChangeCourseNameDTO;
import com.senai.monitoria.sitemonitoria.services.CourseService;
import com.senai.monitoria.sitemonitoria.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/course")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CourseDTO courseDTO) {
        try {
            courseService.save(courseDTO);
            return Response.ok("Curso cadastrado com sucesso!");
        }catch (DataIntegrityViolationException e){
            e.printStackTrace();
            return Response.error("Curso com este nome já cadastrado", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Erro ao cadastrar curso", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            List<ConsultCourseDTO> courseDTOList = courseService.findAll();
            return Response.ok(courseDTOList, "Cursos encontrados com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Erro ao buscar cursos", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") UUID id) {
        try {
            return Response.ok(courseService.findById(id), "Curso encontrado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Erro ao buscar curso", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "change-course-name")
    public ResponseEntity<?> update(@RequestBody ChangeCourseNameDTO courseDTO) {
        try {
            courseService.save(courseDTO);
            return Response.ok("Curso atualizado com sucesso!");
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            return Response.error("Curso com este nome já cadastrado", HttpStatus.BAD_REQUEST);
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return Response.error("Curso não encontrado", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Erro ao atualizar curso", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/add-subject")
    public ResponseEntity<?> addSubjectToCourse(@RequestBody AddSubjectToCourseDTO addSubjectToCourseDTO) {
        try {
            courseService.addSubjectToCourse(addSubjectToCourseDTO);
            return Response.ok("Matéria adicionada ao curso com sucesso!");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return Response.error("Curso ou matéria não encontrados", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Erro ao adicionar matéria ao curso", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
