package com.igor.payment.mapper;

import com.igor.payment.domain.model.OrderModel;
import com.igor.payment.dto.ProductDto;
import com.igor.payment.dto.OrderDto;

import java.time.LocalDateTime;

public class OrderMapper {
    private OrderMapper(){}

    public static OrderModel fromDtoToModel(OrderDto orderDto, ProductDto productDto) {
        return OrderModel.builder()
                .id(orderDto.getId())
                .customerId(orderDto.getCustomerId())
                .originalPrice(productDto.getCurrentPrice())
                .discount(orderDto.getDiscount())
                .dtRegistedOrder(LocalDateTime.now())
                .product(productDto)
                .build();
    }
}
