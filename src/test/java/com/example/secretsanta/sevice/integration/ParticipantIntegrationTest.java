package com.example.secretsanta.sevice.integration;

import com.example.secretsanta.SecretSantaApplicationTests;
import com.example.secretsanta.mapper.ParticipantMapper;
import com.example.secretsanta.model.dto.ParticipantDto;
import com.example.secretsanta.model.entity.Participant;
import com.example.secretsanta.sevice.ParticipantService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class ParticipantIntegrationTest extends SecretSantaApplicationTests {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private ParticipantMapper participantMapper;
    @Autowired
    private ParticipantService participantService;
    @Autowired
    private MockMvc mockMvc;

    private Participant participant1;

    @BeforeEach
    public void setUp() {
        participant1 = createParticipant();
    }

    @Test
    @DisplayName("Create participant by manager")
    void givenParticipant_whenCreate_thenStatus201AndParticipantDtoReturned() throws Exception {
        Participant participant = createParticipant();
        ParticipantDto participantDto = createParticipantDto(participant);
        String json = objectMapper.writeValueAsString(participantDto);
        mockMvc.perform(post("/participants")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value(participantDto.getFirstName()))
                .andExpect(jsonPath("$.lastName").value(participantDto.getLastName()))
                .andExpect(jsonPath("$.email").value(participantDto.getEmail()))
                .andExpect(jsonPath("$.id").isNotEmpty())
        ;
    }

    @Test
    @DisplayName("Update participant by manager")
    void givenParticipant_whenUpdate_thenStatus201AndParticipantDtoReturned() throws Exception {
        ParticipantDto participantDto = createAndSaveParticipantDto();
        participantDto.setFirstName("was updated");
        participantDto.setLastName("was updated");
        participantDto.setEmail("was updated");
        String json = objectMapper.writeValueAsString(participantDto);
        mockMvc.perform(put("/participants")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value(participantDto.getFirstName()))
                .andExpect(jsonPath("$.lastName").value(participantDto.getLastName()))
                .andExpect(jsonPath("$.email").value(participantDto.getEmail()))
                .andExpect(jsonPath("$.id").isNotEmpty())
        ;
    }

    @Test
    @DisplayName("Delete participant")
    void givenValidId_whenDelete_thenStatus200() throws Exception {
        deleteParticipant();
    }

    private void deleteParticipant() throws Exception {
        ParticipantDto participantDto = createAndSaveParticipantDto();
        mockMvc.perform(delete("/participants/{id}", participantDto.getId()))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

    private Participant createParticipant() {
        return Participant.builder()
                .firstName("firstName")
                .lastName("lastname")
                .email("email")
                .build();
    }

    private ParticipantDto createAndSaveParticipantDto() {
        return participantService.createParticipantDto(createParticipant());
    }

    private ParticipantDto createParticipantDto(Participant participant) {
        return participantMapper.toParticipantDto(participant);
    }
}
