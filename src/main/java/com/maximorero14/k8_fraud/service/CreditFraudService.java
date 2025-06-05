package com.maximorero14.k8_fraud.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import io.opentelemetry.instrumentation.annotations.WithSpan;

@Service
public class CreditFraudService {

    private final Random random = new Random();

    @WithSpan
    public boolean checkCreditFraud() {
        try {
            // Espera aleatoria entre 100ms y 400ms
            Thread.sleep(100 + random.nextInt(301));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        // Simula un chequeo aleatorio de fraude basado en crédito
        return random.nextBoolean();
    }
}