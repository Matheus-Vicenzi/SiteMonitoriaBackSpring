package com.senai.monitoria.sitemonitoria.services;

import com.senai.monitoria.sitemonitoria.dto.ConsultMentoringEventDTO;
import com.senai.monitoria.sitemonitoria.dto.ConsultUserDTO;
import com.senai.monitoria.sitemonitoria.dto.CreateMentoringEventDTO;
import com.senai.monitoria.sitemonitoria.entities.MentoringEvent;
import com.senai.monitoria.sitemonitoria.entities.MentoringEventStatus;
import com.senai.monitoria.sitemonitoria.repositories.MentoringEventRepository;
import com.senai.monitoria.sitemonitoria.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class MentoringEventService {
    @Autowired
    private MentoringEventRepository mentoringEventRepository;

    public void createMentoringEventSolicitation(CreateMentoringEventDTO createMentoringEventDTO, ConsultUserDTO userDTO, ConsultUserDTO studentUsetDTO) throws Exception {
        MentoringEvent mentoringEvent = new MentoringEvent();
        mentoringEvent.setMentor(userDTO.dtoToObject());
        mentoringEvent.setStudent(studentUsetDTO.dtoToObject());
        mentoringEvent.setStudentDescription(createMentoringEventDTO.getStudentDescription());
        mentoringEvent.setMentorDescription("");
        mentoringEvent.setRequestDate(TimeUtils.timestampToGregorianCalendar(createMentoringEventDTO.getRequestDate()));
        mentoringEvent.setScheduleDate(TimeUtils.timestampToGregorianCalendar(createMentoringEventDTO.getScheduleDate()));
        mentoringEvent.setMentoringEventStatus(MentoringEventStatus.PENDING);
        mentoringEventRepository.save(mentoringEvent);
    }

    public List<ConsultMentoringEventDTO> findAll() {
        return mentoringEventRepository.findAll().stream().map(ConsultMentoringEventDTO::new).toList();
    }

    public List<ConsultMentoringEventDTO> findMentoringsByDate(LocalDate date) {
        return mentoringEventRepository.findMentoringsByDate(date).stream().map(ConsultMentoringEventDTO::new).toList();
    }

    public List<ConsultMentoringEventDTO> findMentoringsByMentor(UUID mentorId) {
        return mentoringEventRepository.findMentoringsByMentor(mentorId).stream().map(ConsultMentoringEventDTO::new).toList();
    }

    public void changeMentoringStatus(UUID mentoringId, String mentoringEventStatusString) {
        MentoringEventStatus mentoringEventStatus = MentoringEventStatus.valueOf(mentoringEventStatusString);
        MentoringEvent mentoringEvent = mentoringEventRepository.findById(mentoringId).orElseThrow();
        mentoringEvent.setMentoringEventStatus(mentoringEventStatus);
        mentoringEventRepository.save(mentoringEvent);
    }
}
