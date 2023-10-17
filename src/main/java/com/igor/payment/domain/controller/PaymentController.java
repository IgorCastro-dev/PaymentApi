package com.igor.payment.domain.controller;

import com.igor.payment.dto.PaymentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface PaymentController {
    ResponseEntity<Boolean> process(@Valid @RequestBody PaymentDto dto);
}
