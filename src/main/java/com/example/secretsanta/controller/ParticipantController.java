package com.example.secretsanta.controller;

import com.example.secretsanta.model.dto.ParticipantDto;
import com.example.secretsanta.model.entity.Participant;
import com.example.secretsanta.sevice.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/participants")
public class ParticipantController {
    private final ParticipantService participantService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<ParticipantDto> get(@PathVariable Long id) {
        return new ResponseEntity<>(participantService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ParticipantDto> create(@RequestBody Participant participant) {
        return new ResponseEntity<>(participantService.createParticipantDto(participant), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ParticipantDto> update(@RequestBody Participant participant) {
        return new ResponseEntity<>(participantService.updateParticipantDto(participant), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ParticipantDto> delete(@PathVariable Long id) {
        participantService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
