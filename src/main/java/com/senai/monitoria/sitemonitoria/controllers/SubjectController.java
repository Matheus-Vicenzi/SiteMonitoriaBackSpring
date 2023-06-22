package com.senai.monitoria.sitemonitoria.controllers;

import com.senai.monitoria.sitemonitoria.dto.ConsultSubjectDTO;
import com.senai.monitoria.sitemonitoria.dto.SaveSubjectDTO;
import com.senai.monitoria.sitemonitoria.dto.SubjectDTO;
import com.senai.monitoria.sitemonitoria.services.CourseService;
import com.senai.monitoria.sitemonitoria.services.SubjectService;
import com.senai.monitoria.sitemonitoria.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        try{
            List<ConsultSubjectDTO> allSubjects = subjectService.findAll();
            return Response.ok(allSubjects,"Matérias encontradas com sucesso!");
        }catch (Exception e){
            e.printStackTrace();
            return Response.error("Erro ao buscar matérias", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody SaveSubjectDTO saveSubjectDTO){
        try {
            subjectService.save(saveSubjectDTO);
            return Response.ok("Matéria salva com sucesso!");
        }catch (Exception e){
            e.printStackTrace();
            return Response.error("Erro ao salvar a matéria", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/add-mentor-to-subject/{mentorId}/{subjectId}")
    public ResponseEntity<?> addMentorToSubject(@PathVariable UUID mentorId, @PathVariable UUID subjectId){
        try {
            subjectService.addMentorToSubject(mentorId, subjectId);
            return Response.ok("Monitor adicionado à matéria com sucesso!");
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return Response.error("Monitor ou matéria não encontrados", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return Response.error("Erro ao adicionar monitor à matéria", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        try {
            subjectService.delete(id);
            return Response.ok("Matéria deletada com sucesso!");
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return Response.error("Matéria não encontrada", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return Response.error("Erro ao deletar matéria", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
