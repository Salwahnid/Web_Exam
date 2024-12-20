package com.example.cabinetdentistrybackend.model;

import lombok.Data;

@Data
public class SecretaryRegistrationRequest {
    // Getters et Setters
    private Secretary secretaryRequest;
    private PaymentAccountRequest paymentAccountRequest;

    public void setSecretaryRequest(Secretary secretaryRequest) {
        this.secretaryRequest = secretaryRequest;
    }

    public void setPaymentAccountRequest(PaymentAccountRequest paymentAccountRequest) {
        this.paymentAccountRequest = paymentAccountRequest;
    }
}
