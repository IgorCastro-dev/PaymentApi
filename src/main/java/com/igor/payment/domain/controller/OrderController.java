package com.igor.payment.domain.controller;

import com.igor.payment.domain.model.OrderModel;
import com.igor.payment.dto.OrderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface OrderController {
    ResponseEntity<OrderModel> create(@Valid @RequestBody OrderDto orderDto);
}
