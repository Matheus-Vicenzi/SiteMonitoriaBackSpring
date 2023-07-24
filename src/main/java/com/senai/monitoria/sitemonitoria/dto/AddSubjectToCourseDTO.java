package com.senai.monitoria.sitemonitoria.dto;

import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Getter
@Data
public class AddSubjectToCourseDTO {
    private UUID courseId;
    private UUID subjectId;
}
