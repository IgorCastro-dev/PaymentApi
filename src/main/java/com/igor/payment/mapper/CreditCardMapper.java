package com.igor.payment.mapper;

import com.igor.payment.domain.model.CreditCardModel;
import com.igor.payment.dto.CreditCardDto;

public class CreditCardMapper {
    private CreditCardMapper(){}

    public static CreditCardModel fromDtoToModel(CreditCardDto dto, String customerId) {
        return CreditCardModel.builder()
                .number(dto.getNumber())
                .cvv(dto.getCvv())
                .month(dto.getMonth())
                .year(dto.getYear())
                .documentNumber(dto.getDocumentNumber())
                .installments(dto.getInstallments())
                .customerId(customerId)
                .build();
    }

    public static CreditCardDto fromModelToDto(CreditCardModel model) {
        return CreditCardDto.builder()
                .number(model.getNumber())
                .cvv(model.getCvv())
                .month(model.getMonth())
                .year(model.getYear())
                .documentNumber(model.getDocumentNumber())
                .installments(model.getInstallments())
                .build();
    }
}
