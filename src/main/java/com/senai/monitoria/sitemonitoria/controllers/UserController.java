package com.senai.monitoria.sitemonitoria.controllers;

import com.senai.monitoria.sitemonitoria.dto.UserDTO;
import com.senai.monitoria.sitemonitoria.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> findAll(){
        return userService.findAll();
    }

    @PostMapping
    public @ResponseBody UserDTO save(@RequestBody UserDTO userDTO){
        return userService.save(userDTO);
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody UserDTO update(@RequestBody UserDTO userDTO){
        return userService.save(userDTO);
    }

    @GetMapping(value = "/{id}")
    public UserDTO findById(@PathVariable Long id){
        return userService.findById(id);
    }


}
