package com.igor.payment.domain.service;

import com.igor.payment.domain.model.OrderModel;
import com.igor.payment.dto.OrderDto;

public interface OrderService {
    OrderModel create(OrderDto orderDto);
}
