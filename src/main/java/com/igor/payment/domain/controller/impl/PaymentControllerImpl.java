package com.igor.payment.domain.controller.impl;

import com.igor.payment.domain.controller.PaymentController;
import com.igor.payment.domain.service.PaymentService;
import com.igor.payment.dto.PaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/payment")
public class PaymentControllerImpl implements PaymentController {

    @Autowired
    private PaymentService paymentService;
    @PostMapping("/credit-card/")
    public ResponseEntity<Boolean> process(PaymentDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.process(dto));
    }
}
