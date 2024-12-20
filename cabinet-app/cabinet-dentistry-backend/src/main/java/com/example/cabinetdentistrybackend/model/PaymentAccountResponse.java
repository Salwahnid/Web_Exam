package com.example.cabinetdentistrybackend.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentAccountResponse {

    private Long id;
    private double balance;
    private String type;

}
