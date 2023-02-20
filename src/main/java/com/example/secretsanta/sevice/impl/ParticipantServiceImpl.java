package com.example.secretsanta.sevice.impl;

import com.example.secretsanta.mapper.ParticipantMapper;
import com.example.secretsanta.model.dto.ParticipantDto;
import com.example.secretsanta.model.entity.Participant;
import com.example.secretsanta.sevice.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {
    private Long participantAutoIncrementIndex = 1L;
    private final ParticipantMapper participantMapper;
    private final Map<Long, Participant> participantMap = new ConcurrentHashMap<>();

    @Override
    public synchronized ParticipantDto createParticipantDto(Participant participant) {
        participant.setId(participantAutoIncrementIndex++);
        return participantMapper.toParticipantDto(participantMap.put(participant.getId(), participant));
    }

    @Override
    public ParticipantDto updateParticipantDto(Participant participant) {
        if (participantMap.isEmpty()) {
            throw new NotFoundException("No product updated with such id = " + participant.getId());
        } else {
            participantMap.put(participant.getId(), participant);
            return participantMapper.toParticipantDto(participant);
        }
    }

    @Override
    public void deleteById(Long id) {
        Participant participant = participantMap.get(id);
        if (participant == null) {
            throw new NotFoundException("No product deleted with such id = " + id);
        } else {
            participantMap.remove(id);
        }
    }

    @Override
    public Map<Long, Participant> getAll() {
        return participantMap;
    }

    public ParticipantDto getById(Long id) {
        return participantMapper.toParticipantDto(participantMap.get(id));
    }
}
