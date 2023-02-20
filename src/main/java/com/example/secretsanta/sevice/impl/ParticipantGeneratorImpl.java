package com.example.secretsanta.sevice.impl;

import com.example.secretsanta.exceptions.NotEnoughParticipants;
import com.example.secretsanta.model.entity.Assignment;
import com.example.secretsanta.sevice.ParticipantGenerator;
import com.example.secretsanta.sevice.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class ParticipantGeneratorImpl implements ParticipantGenerator {
    private final ParticipantService participantService;

    @Override
    public Set<Assignment> createGenerator() {
        List<Long> shuffled = new ArrayList<>(participantService.getAll().keySet());
        if (shuffled.size() < 3) {
            throw new NotEnoughParticipants();
        }
        Collections.shuffle(shuffled);
        Set<Assignment> assignments = new HashSet<>();
        IntStream
                .range(0, shuffled.size() - 1)
                .mapToObj(i -> Assignment
                        .builder()
                        .giverId(shuffled.get(i))
                        .takerId(shuffled.get(i + 1))
                        .build()
                )
                .forEach(assignments::add);
        assignments
                .add(Assignment
                        .builder()
                        .giverId(shuffled.get(shuffled.size() - 1))
                        .takerId(shuffled.get(0))
                        .build());
        return assignments;
    }
}
