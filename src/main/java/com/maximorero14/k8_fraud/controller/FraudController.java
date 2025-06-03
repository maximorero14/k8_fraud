package com.maximorero14.k8_fraud.controller;

import com.maximorero14.k8_fraud.dto.PaymentRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/fraud")
public class FraudController {

    private final Random random = new Random();

    @GetMapping("/check")
    public Map<String, Boolean> checkFraud(PaymentRequest paymentRequest) {
        boolean result = random.nextInt(10) < 9;
        Map<String, Boolean> response = new HashMap<>();
        response.put("fraud", result);
        return response;
    }
}