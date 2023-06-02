package com.senai.monitoria.sitemonitoria.controllers;

import com.senai.monitoria.sitemonitoria.dto.UserDTO;
import com.senai.monitoria.sitemonitoria.dto.UserToMentorDataDTO;
import com.senai.monitoria.sitemonitoria.services.UserService;
import com.senai.monitoria.sitemonitoria.utils.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/api/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            List<UserDTO> users = userService.findAll();
            return Response.ok(users, "Usuários encontrados com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Erro ao buscar usuários", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody UserDTO userDTO) {
        try {
            userService.save(userDTO);
            return Response.ok("Usuário cadastrado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Erro ao cadastrar usuário", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@RequestBody UserDTO userDTO, @PathVariable Long id) {
        try {
            userService.update(userDTO, id);
            return Response.ok("Usuário atualizado com sucesso!");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return Response.error("Usuário não encontrado", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Erro ao atualizar usuário", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            UserDTO userDTO = userService.findById(id);
            return Response.ok(userDTO, "Usuário encontrado com sucesso!");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return Response.error("Usuário não encontrado", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Erro ao buscar usuário", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            userService.delete(id);
            return Response.ok("Usuário deletado com sucesso!");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return Response.error("Usuário não encontrado", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Erro ao deletar usuário", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/user-to-mentor/{id}")
    public ResponseEntity<?> userToMentor(@PathVariable long id, @RequestBody UserToMentorDataDTO userToMentorDataDTO) {
        try {
            userService.userToMentor(id, userToMentorDataDTO);
            return Response.ok("Usuário atualizado para monitor com sucesso!");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return Response.error("Usuário não encontrado", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Erro ao atualizar usuário", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/user-to-admin/{id}")
    public ResponseEntity<?> userToAdmin(@PathVariable long id) {
        try {
            userService.userToAdmin(id);
            return Response.ok("Usuário atualizado para administrador com sucesso!");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return Response.error("Usuário não encontrado", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Erro ao atualizar usuário", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(value = "/user-to-student/{id}")
    public ResponseEntity<?> userToStudent(@PathVariable long id){
        try {
            userService.userToStudent(id);
            return Response.ok("Usuário atualizado para estudante com sucesso!");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return Response.error("Usuário não encontrado", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Erro ao atualizar usuário", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}


