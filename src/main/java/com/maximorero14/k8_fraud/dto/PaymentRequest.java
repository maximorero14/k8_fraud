package com.maximorero14.k8_fraud.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentRequest {
    private BigDecimal amount;
    private String currency;
    private String method;
    private String userId;
}
