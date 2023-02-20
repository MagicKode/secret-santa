package com.example.secretsanta.sevice.impl;

import com.example.secretsanta.exceptions.NotEnoughParticipants;
import com.example.secretsanta.model.entity.Assignment;
import com.example.secretsanta.model.entity.Participant;
import com.example.secretsanta.sevice.ParticipantService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ParticipantGeneratorImplTest {
    @Mock
    ParticipantService participantService;
    @InjectMocks
    ParticipantGeneratorImpl testSubject;

    @Test
    void shouldCheckThreeParticipants() {
        //given
        Participant firstParticipant = createParticipant(1L, "firstName", "lastName", "firstEmail");
        Participant secondParticipant = createParticipant(2L, "secondName", "lastSecondName", "secondEmail");
        Participant thirdParticipant = createParticipant(3L, "thirdName", "lastThirdName", "thirdEmail");
        when(participantService.getAll()).thenReturn(Map.of(
                firstParticipant.getId(), firstParticipant,
                secondParticipant.getId(), secondParticipant,
                thirdParticipant.getId(), thirdParticipant
        ));
        for (int i = 0; i < 60; i++) {
            //when
            Set<Assignment> result = testSubject.createGenerator();
            //then
            assertTrue(result
                    .stream()
                    .allMatch(a -> a.getGiverId() != a.getTakerId()));
            assertEquals(participantService.getAll().keySet(), result
                    .stream()
                    .map(Assignment::getGiverId)
                    .collect(Collectors.toSet()));
            assertEquals(participantService.getAll().keySet(), result
                    .stream()
                    .map(Assignment::getTakerId)
                    .collect(Collectors.toSet()));
        }
    }

    @Test
    void givenLessThanThreeParticipants_whenCreateGenerator_thenThrow() {
        // given
        Participant firstParticipant = createParticipant(1L, "firstName", "lastName", "firstEmail");
        Participant secondParticipant = createParticipant(2L, "secondName", "lastSecondName", "secondEmail");
        when(participantService.getAll()).thenReturn(Map.of(firstParticipant.getId(), firstParticipant,
                secondParticipant.getId(), secondParticipant));

        // when
        NotEnoughParticipants exception = assertThrows(NotEnoughParticipants.class, () -> {
            testSubject.createGenerator();
        });
        String expectedMessage = "Number of participants should be 3 or greater";
        String actualMessage = exception.getMessage();
        //then
        assertTrue(actualMessage.contains(expectedMessage));
    }

    private Participant createParticipant(Long id, String firstName, String lastName, String email) {
        Participant participant = new Participant();
        participant.setId(id);
        participant.setFirstName(firstName);
        participant.setLastName(lastName);
        participant.setEmail(email);
        return participant;
    }
}