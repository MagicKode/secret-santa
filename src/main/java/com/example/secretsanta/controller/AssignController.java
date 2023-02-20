package com.example.secretsanta.controller;

import com.example.secretsanta.model.dto.AssignmentDto;
import com.example.secretsanta.sevice.AssignmentConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@RequiredArgsConstructor
@Controller
@RequestMapping(path = "/assign")
public class AssignController {
    private final AssignmentConverter assignmentConverter;

    @PostMapping
    public ResponseEntity<Set<AssignmentDto>> assign() {
        return new ResponseEntity<>(assignmentConverter.createGenerator(), HttpStatus.OK);
    }
}
