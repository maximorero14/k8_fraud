package com.maximorero14.k8_fraud.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maximorero14.k8_fraud.dto.FraudCheckResponse;
import com.maximorero14.k8_fraud.dto.PaymentRequest;
import com.maximorero14.k8_fraud.service.CreditFraudService;
import com.maximorero14.k8_fraud.service.IdentityFraudService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/fraud")
@Slf4j
public class FraudController {

    private final Random random = new Random();

    @Autowired
    private CreditFraudService creditFraudService;

    @Autowired
    private IdentityFraudService identityFraudService;

    @PostMapping("/check")
    public FraudCheckResponse checkFraud(@RequestBody PaymentRequest paymentRequest) {
        boolean result = !(random.nextInt(10) < 9);
        FraudCheckResponse fraudCheckResponse = new FraudCheckResponse();
        fraudCheckResponse.setFraud(result);

        boolean creditFraud = creditFraudService.checkCreditFraud();
        boolean identityFraud = identityFraudService.checkIdentityFraud();

        log.info("response {} {}", paymentRequest, fraudCheckResponse);
        return fraudCheckResponse;
    }
}