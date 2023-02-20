package com.example.secretsanta.sevice.impl;

import com.example.secretsanta.model.dto.AssignmentDto;
import com.example.secretsanta.model.dto.ParticipantDto;
import com.example.secretsanta.model.entity.Assignment;
import com.example.secretsanta.model.entity.Participant;
import com.example.secretsanta.sevice.ParticipantGenerator;
import com.example.secretsanta.sevice.ParticipantService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AssignmentConverterTest {

    @Mock
    ParticipantService participantService;

    @Mock
    ParticipantGenerator participantGenerator;

    @InjectMocks
    AssignmentConverterImpl testSubject;

    @Test
    void shouldMapIntoDto() {
        //given
        Assignment assignment1 = new Assignment(1L, 2L);
        Assignment assignment2 = new Assignment(2L, 1L);
        ParticipantDto firstParticipantDto = createParticipant(1L, "firstName", "lastName", "firstEmail");
        ParticipantDto secondParticipantDto = createParticipant(2L, "secondName", "lastSecondName", "secondEmail");
        when(participantService.getById(firstParticipantDto.getId())).thenReturn(firstParticipantDto);
        when(participantService.getById(secondParticipantDto.getId())).thenReturn(secondParticipantDto);
        when(participantGenerator.createGenerator()).thenReturn(Set.of(assignment1, assignment2));
        //when
        Set<AssignmentDto> result = testSubject.createGenerator();
        //then
        assertEquals(Set.of(
                AssignmentDto.builder().giver(firstParticipantDto).taker(secondParticipantDto).build(),
                AssignmentDto.builder().giver(secondParticipantDto).taker(firstParticipantDto).build()
        ), result);
    }

    private ParticipantDto createParticipant(Long id, String firstName, String lastName, String email) {
        ParticipantDto participant = new ParticipantDto();
        participant.setId(id);
        participant.setFirstName(firstName);
        participant.setLastName(lastName);
        participant.setEmail(email);
        return participant;
    }
}
