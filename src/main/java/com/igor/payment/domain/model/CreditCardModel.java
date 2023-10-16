package com.igor.payment.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("creditCard")
public class CreditCardModel {
    @Id
    private String id;

    @NotBlank
    private String number;

    @NotNull
    private Long cvv;

    @NotNull
    private Long month;

    @NotNull
    private Long year;

    @NotBlank
    private String documentNumber;

    @NotNull
    private Long installments;

    @NotBlank
    private String customerId;
}
