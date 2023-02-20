package com.example.secretsanta.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class AssignmentDto {
    private final ParticipantDto giver;
    private final ParticipantDto taker;
}
