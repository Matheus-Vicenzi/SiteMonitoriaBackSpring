package com.senai.monitoria.sitemonitoria.controllers;

import com.senai.monitoria.sitemonitoria.dto.MentorUserDTO;
import com.senai.monitoria.sitemonitoria.entities.MentorUser;
import com.senai.monitoria.sitemonitoria.services.MentorUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/mentor")
public class MentorUserController {
    @Autowired
    private MentorUserService mentorUserService;

    @GetMapping(value = "/save")
    public MentorUserDTO save(@RequestBody MentorUser mentorUser){
        MentorUserDTO mentorUserDTO = new MentorUserDTO(mentorUser);
        return mentorUserService.save(mentorUserDTO);
    }
}
