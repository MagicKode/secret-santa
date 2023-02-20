package com.example.secretsanta.sevice;

import com.example.secretsanta.model.dto.AssignmentDto;

import java.util.Set;

public interface AssignmentConverter {
    Set<AssignmentDto> createGenerator();
}
