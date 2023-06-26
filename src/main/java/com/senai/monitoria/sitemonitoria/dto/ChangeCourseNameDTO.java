package com.senai.monitoria.sitemonitoria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
@Data
public class ChangeCourseNameDTO {
    private String newCourseName;
    private UUID id;
}
