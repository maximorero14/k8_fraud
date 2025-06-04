package com.maximorero14.k8_fraud.controller;

import com.maximorero14.k8_fraud.dto.FraudCheckResponse;
import com.maximorero14.k8_fraud.dto.PaymentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/fraud")
@Slf4j
public class FraudController {

    private final Random random = new Random();

    @PostMapping("/check")
    public FraudCheckResponse checkFraud(@RequestBody PaymentRequest paymentRequest) {
        boolean result = random.nextInt(10) < 9;
        FraudCheckResponse fraudCheckResponse = new FraudCheckResponse();
        fraudCheckResponse.setFraud(result);
        log.info("response {} {}", paymentRequest, fraudCheckResponse);
        return fraudCheckResponse;
    }
}