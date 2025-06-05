package com.maximorero14.k8_fraud.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import io.opentelemetry.instrumentation.annotations.WithSpan;

@Service
public class IdentityFraudService {

    private final Random random = new Random();

    @WithSpan
    public boolean checkIdentityFraud() {
        try {
            // Espera aleatoria entre 100ms y 400ms
            Thread.sleep(100 + random.nextInt(301));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        // Simula un chequeo con un 20% de probabilidad de fraude
        return random.nextInt(100) < 20;
    }
}