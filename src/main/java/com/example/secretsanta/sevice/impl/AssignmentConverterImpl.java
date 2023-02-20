package com.example.secretsanta.sevice.impl;

import com.example.secretsanta.model.dto.AssignmentDto;
import com.example.secretsanta.sevice.AssignmentConverter;
import com.example.secretsanta.sevice.ParticipantGenerator;
import com.example.secretsanta.sevice.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AssignmentConverterImpl implements AssignmentConverter {
    private final ParticipantGenerator participantGenerator;
    private final ParticipantService participantService;

    @Override
    public Set<AssignmentDto> createGenerator() {
        return participantGenerator.createGenerator()
                .stream()
                .map(a -> AssignmentDto
                        .builder()
                        .giver(participantService.getById(a.getGiverId()))
                        .taker(participantService.getById(a.getTakerId()))
                        .build())
                .collect(Collectors.toSet());
    }
}
