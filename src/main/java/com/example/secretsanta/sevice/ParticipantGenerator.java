package com.example.secretsanta.sevice;

import com.example.secretsanta.model.entity.Assignment;

import java.util.Set;

public interface ParticipantGenerator {
    Set<Assignment> createGenerator();
}
