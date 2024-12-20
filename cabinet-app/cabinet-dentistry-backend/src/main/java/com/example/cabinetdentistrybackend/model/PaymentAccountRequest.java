package com.example.cabinetdentistrybackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentAccountRequest {

    private Long id;
//    private double balance;
    private String type;
}
