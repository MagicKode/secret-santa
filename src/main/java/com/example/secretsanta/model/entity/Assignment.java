package com.example.secretsanta.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Assignment {
    private final long giverId;
    private final long takerId;
}
