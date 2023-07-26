package com.senai.monitoria.sitemonitoria.controllers;

import com.senai.monitoria.sitemonitoria.dto.ConsultUserDTO;
import com.senai.monitoria.sitemonitoria.dto.CreateMentoringEventDTO;
import com.senai.monitoria.sitemonitoria.services.MentoringEventService;
import com.senai.monitoria.sitemonitoria.services.UserService;
import com.senai.monitoria.sitemonitoria.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/mentoring-event")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MentoringEventController {

    @Autowired
    private MentoringEventService mentoringEventService;
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> createMentoringEventSolicitation(@RequestBody CreateMentoringEventDTO createMentoringEventDTO){
        try{
            ConsultUserDTO mentorUserDTO = userService.findById(createMentoringEventDTO.getMentorId());
            ConsultUserDTO studentUsetDTO = userService.findById(createMentoringEventDTO.getStudentId());
            mentoringEventService.createMentoringEventSolicitation(createMentoringEventDTO, mentorUserDTO, studentUsetDTO);
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return Response.error("Usuário não encontrado", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return Response.error("Erro ao criar solicitação de mentoria", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return Response.ok("Solicitação de monitoria criada com sucesso");
    }

    @GetMapping
    public ResponseEntity<?> getAllMentoringEvents(){
        try{
            return Response.ok(mentoringEventService.findAll(), "Solicitações de monitoria encontradas com sucesso");
        }catch (Exception e){
            e.printStackTrace();
            return Response.error("Erro ao buscar solicitações de monitoria", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @param date - Date in format yyyy-MM-dd
     */
    @GetMapping(value = "/get-mentoring-by-date/{date}")
    public ResponseEntity<?> findMentoringByDate(@PathVariable LocalDate date){
        try{
            return Response.ok(mentoringEventService.findMentoringsByDate(date), "Monitorias encontradas com sucesso");
        }catch (Exception e){
            e.printStackTrace();
            return Response.error("Erro ao buscar horários disponíveis", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/get-mentoring-by-mentor/{mentorId}")
    public ResponseEntity<?> findMentoringByMentor(@PathVariable UUID mentorId){
        try{
            return Response.ok(mentoringEventService.findMentoringsByMentor(mentorId), "Monitorias encontradas com sucesso");
        }catch (Exception e){
            e.printStackTrace();
            return Response.error("Erro ao buscar horários disponíveis", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/change-status/{mentoringEventId}/{status}")
    public ResponseEntity<?> changeMentoringStatus(@PathVariable UUID mentoringEventId, @PathVariable String status){
        try{
            mentoringEventService.changeMentoringStatus(mentoringEventId, status);
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return Response.error("Solicitação de monitoria não encontrada", HttpStatus.NOT_FOUND);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return Response.error("Status inválido", HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return Response.error("Erro ao alterar status da solicitação de monitoria", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return Response.ok("Status da solicitação de monitoria alterado com sucesso");
    }

}
