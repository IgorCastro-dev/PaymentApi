package com.igor.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDto {
    @NotBlank(message = "customerId é obrigatório")
    private String customerId;

    @NotBlank(message = "orderId é obrigatório")
    private String orderId;

    @NotNull(message = "creditCard é obrigatório")
    private CreditCardDto creditCard;
}
