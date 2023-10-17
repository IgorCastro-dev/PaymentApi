package com.igor.payment.domain.service;

import com.igor.payment.dto.PaymentDto;

public interface PaymentService {
    Boolean process(PaymentDto paymentDto);
}
