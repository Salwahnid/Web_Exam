package com.example.cabinetdentistrybackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    private String refOperation;
    private Long idClient;
    private Long idCreditor;
    private Long idService;
    private double amount;



}
