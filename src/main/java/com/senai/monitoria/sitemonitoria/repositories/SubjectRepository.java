package com.senai.monitoria.sitemonitoria.repositories;

import com.senai.monitoria.sitemonitoria.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubjectRepository extends JpaRepository<Subject, UUID>{
}
