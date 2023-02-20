package com.example.secretsanta.sevice.impl;

import com.example.secretsanta.mapper.ParticipantMapper;
import com.example.secretsanta.model.dto.ParticipantDto;
import com.example.secretsanta.model.entity.Participant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.webjars.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ParticipantServiceImplTest {
    @Mock
    ParticipantMapper participantMapper;
    @InjectMocks
    ParticipantServiceImpl testSubject;

    @Test
    void shouldCreate() {
        //given
        Participant participant = createParticipant();
        ParticipantDto participantDto = createParticipantDto(participant);
        when(participantMapper.toParticipantDto(participant)).thenReturn(participantDto);
        //when
        ParticipantDto result = testSubject.createParticipantDto(participant);
        //then
        assertEquals(participant.getFirstName(), result.getFirstName());
        assertEquals(participant.getLastName(), result.getLastName());
        assertEquals(participant.getEmail(), result.getEmail());
        verify(participantMapper, times(1)).toParticipantDto(participant);
    }

    @Test
    void shouldUpdate() {
        //given
        Participant oldParticipant = createParticipant();
        oldParticipant.setLastName("OldLastName");
        testSubject.getAll().put(oldParticipant.getId(), oldParticipant);
        Participant newParticipant = createParticipant();
        ParticipantDto participantDto = createParticipantDto(newParticipant);
        when(participantMapper.toParticipantDto(eq(newParticipant))).thenReturn(participantDto);
        //when
        ParticipantDto result = testSubject.updateParticipantDto(newParticipant);
        //then
        assertEquals(participantDto, result);
    }

    @Test
    void shouldNotUpdate_thenException() {
        //given
        Participant participant = createParticipant();
        //when
        Exception exception = assertThrows(NotFoundException.class, () -> {
            testSubject.updateParticipantDto(participant);
        });
        String expectedMessage = "No product updated with such id = " + participant.getId();
        String actualMessage = exception.getMessage();
        //then
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void shouldDeleteById() {
        //given
        Long id = 1L;
        Participant participant = createParticipant();
        testSubject.getAll().put(participant.getId(), participant);
        //when
        testSubject.deleteById(id);
        //then
        assertTrue(testSubject.getAll().isEmpty());
    }

    @Test
    void shouldNotDeleteById_thenException() {
        //given
        Long id = 1L;
        //when
        Exception exception = assertThrows(NotFoundException.class, () -> {
            testSubject.deleteById(id);
        });
        String expectedMessage = "No product deleted with such id = " + id;
        String actualMessage = exception.getMessage();
        //then
        assertTrue(actualMessage.contains(expectedMessage));
    }

    private Participant createParticipant() {
        Participant participant = new Participant();
        participant.setId(1L);
        participant.setFirstName("first name");
        participant.setLastName("last name");
        participant.setEmail("email");
        return participant;
    }

    private ParticipantDto createParticipantDto(Participant participant) {
        ParticipantDto participantDto = new ParticipantDto();
        participantDto.setId(participant.getId());
        participantDto.setFirstName(participant.getFirstName());
        participantDto.setLastName(participant.getLastName());
        participantDto.setEmail(participant.getEmail());
        return participantDto;
    }
}
