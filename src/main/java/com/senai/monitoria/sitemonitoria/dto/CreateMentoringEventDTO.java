package com.senai.monitoria.sitemonitoria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Data
public class CreateMentoringEventDTO {
    private UUID mentorId;
    private UUID studentId;
    private String studentDescription;
    private String requestDate;
    private String scheduleDate;

}
