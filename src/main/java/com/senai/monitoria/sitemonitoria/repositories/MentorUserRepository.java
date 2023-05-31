package com.senai.monitoria.sitemonitoria.repositories;

import com.senai.monitoria.sitemonitoria.entities.MentorUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MentorUserRepository extends JpaRepository<MentorUser, Long> {
}
