package com.senai.monitoria.sitemonitoria.controllers;

import com.senai.monitoria.sitemonitoria.dto.LoginDTO;
import com.senai.monitoria.sitemonitoria.dto.LoginResponseDTO;
import com.senai.monitoria.sitemonitoria.services.LoginService;
import com.senai.monitoria.sitemonitoria.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/security/login")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LoginController {

    @Autowired
    private LoginService loginService;
    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        try {
            LoginResponseDTO loginResponseDTO = loginService.validateLogin(loginDTO);
            return Response.ok(loginResponseDTO, "Login realizado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("Erro ao realizar login", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

