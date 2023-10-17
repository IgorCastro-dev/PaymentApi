package com.igor.payment.domain.controller.impl;

import com.igor.payment.domain.controller.OrderController;
import com.igor.payment.domain.model.OrderModel;
import com.igor.payment.domain.service.OrderService;
import com.igor.payment.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/order")
public class OrderControllerImpl implements OrderController {

    @Autowired
    private OrderService orderService;
    @PostMapping
    public ResponseEntity<OrderModel> create(OrderDto orderDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.create(orderDto));
    }
}
