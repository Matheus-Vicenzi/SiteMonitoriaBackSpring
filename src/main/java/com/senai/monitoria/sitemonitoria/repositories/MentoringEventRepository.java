package com.senai.monitoria.sitemonitoria.repositories;

import com.senai.monitoria.sitemonitoria.entities.MentoringEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface MentoringEventRepository extends JpaRepository<MentoringEvent, UUID> {

    @Query("SELECT ev FROM MentoringEvent ev WHERE DATE(ev.scheduleDate) = :date")
    List<MentoringEvent> findMentoringsByDate(@Param("date") LocalDate date);

    @Query("SELECT ev FROM MentoringEvent ev WHERE ev.mentor.id = :mentorId")
    List<MentoringEvent> findMentoringsByMentor(UUID mentorId);
}
