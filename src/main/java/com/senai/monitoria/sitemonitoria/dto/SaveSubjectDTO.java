package com.senai.monitoria.sitemonitoria.dto;

import com.senai.monitoria.sitemonitoria.entities.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Set;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Data
public class SaveSubjectDTO implements DTOInterface{
    private String name;
    private Set<UUID> coursesId;

    @Override
    public Subject dtoToObject() {
        return new Subject();
    }
}
