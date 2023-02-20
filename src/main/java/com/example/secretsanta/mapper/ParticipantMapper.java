package com.example.secretsanta.mapper;

import com.example.secretsanta.model.entity.Participant;
import com.example.secretsanta.model.dto.ParticipantDto;
import org.mapstruct.Mapper;

@Mapper
public interface ParticipantMapper {
    ParticipantDto toParticipantDto(Participant participant);
}
