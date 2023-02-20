package com.example.secretsanta.sevice;

import com.example.secretsanta.model.dto.ParticipantDto;
import com.example.secretsanta.model.entity.Participant;

import java.util.Map;

public interface ParticipantService {
    ParticipantDto createParticipantDto(Participant participant);

    ParticipantDto updateParticipantDto(Participant participant);

    ParticipantDto getById(Long id);

    void deleteById(Long id);

    Map<Long, Participant> getAll();


}
