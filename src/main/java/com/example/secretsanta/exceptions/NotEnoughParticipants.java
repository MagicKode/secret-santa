package com.example.secretsanta.exceptions;

public class NotEnoughParticipants extends RuntimeException {
    public NotEnoughParticipants() {
        super("Number of participants should be 3 or greater");
    }
}
