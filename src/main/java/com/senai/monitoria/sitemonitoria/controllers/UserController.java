package com.senai.monitoria.sitemonitoria.controllers;

import com.senai.monitoria.sitemonitoria.dto.*;
import com.senai.monitoria.sitemonitoria.services.UserService;
import com.senai.monitoria.sitemonitoria.utils.Response;
import com.senai.monitoria.sitemonitoria.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

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
            userDTO.setPassword(SecurityUtils.encrypt(userDTO.getPassword()));
            userService.save(userDTO);
            return Response.ok("Usuário cadastrado com sucesso!");
        }catch (DataIntegrityViolationException e){
            e.printStackTrace();
            return Response.error("Usuário com este e-mail já cadastrado", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Erro ao cadastrar usuário", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@RequestBody UserDTO userDTO, @PathVariable UUID id) {
        try {
            userService.update(userDTO, id);
            return Response.ok("Usuário atualizado com sucesso!");
        } catch (DataIntegrityViolationException e){
            return Response.error("Usuário com este e-mail já cadastrado", HttpStatus.BAD_REQUEST);
        } catch (NoSuchElementException e) {
            return Response.error("Usuário não encontrado", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Erro ao atualizar usuário", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id) {
        try {
            ConsultUserDTO userDTO = userService.findById(id);
            return Response.ok(userDTO, "Usuário encontrado com sucesso!");
        } catch (NoSuchElementException e) {
            return Response.error("Usuário não encontrado", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Erro ao buscar usuário", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deactivate(@PathVariable UUID id) {
        try {
            userService.deactivate(id);
            return Response.ok("Usuário inativado com sucesso!");
        } catch (NoSuchElementException e) {
            return Response.error("Usuário não encontrado", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Erro ao desativar usuário", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/user-to-mentor/{id}")
    public ResponseEntity<?> userToMentor(@PathVariable UUID id, @RequestBody UserToMentorDataDTO userToMentorDataDTO) {
        try {
            userService.userToMentor(id, userToMentorDataDTO);
            return Response.ok("Usuário atualizado para monitor com sucesso!");
        } catch (NoSuchElementException e) {
            return Response.error("Usuário não encontrado", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Erro ao atualizar usuário", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/user-to-admin/{id}")
    public ResponseEntity<?> userToAdmin(@PathVariable UUID id) {
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
    public ResponseEntity<?> userToStudent(@PathVariable UUID id){
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

    @GetMapping(value = "/get-active-users")
    public ResponseEntity<?> findActiveUsers(){
        try {
            List<UserDTO> users = userService.findActiveUsers();
            return Response.ok(users, "Usuários encontrados com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Erro ao buscar usuários", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/change-user-level")
    public ResponseEntity<?> changeUserStatus(@RequestBody ChangeUserLevelDTO changeUserLevelDTO){
        try {
            userService.changeUserLevel(changeUserLevelDTO);
            return Response.ok("Nível de usuário alterado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Erro ao alterar nível de usuário", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/change-password")
    public ResponseEntity<?> changePassword(@RequestBody LoginDTO loginDTO){
        try {
            userService.changePassword(loginDTO);
            return Response.ok("Senha alterada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Erro ao alterar senha", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}


