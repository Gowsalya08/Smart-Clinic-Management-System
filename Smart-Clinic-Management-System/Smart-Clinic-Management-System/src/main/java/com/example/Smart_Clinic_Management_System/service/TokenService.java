package com.example.Smart_Clinic_Management_System.service;

import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TokenService {

    private final ConcurrentHashMap<String, Long> tokens = new ConcurrentHashMap<>();

    public String generateToken(Long userId) {
        String token = UUID.randomUUID().toString();
        tokens.put(token, userId);
        return token;
    }

    public Long getUserIdFromToken(String token) {
        return tokens.get(token);
    }

    public boolean validateToken(String token) {
        return tokens.containsKey(token);
    }

    public void invalidateToken(String token) {
        tokens.remove(token);
    }
}
