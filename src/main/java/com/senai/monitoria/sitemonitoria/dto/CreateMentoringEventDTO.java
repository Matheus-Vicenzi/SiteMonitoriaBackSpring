package com.senai.monitoria.sitemonitoria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Data
public class CreateMentoringEventDTO implements DTOInterface{
    private UUID mentorId;
    private UUID studentId;
    private String studentDescription;
    private String requestDate;
    private String scheduleDate;

    @Override
    public Object dtoToObject() {
        throw new RuntimeException("Not implemented");
    }
}
