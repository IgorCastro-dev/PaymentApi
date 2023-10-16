package com.igor.payment.domain.controller;

import com.igor.payment.domain.model.CustomerModel;
import com.igor.payment.dto.CustomerDto;
import org.springframework.http.ResponseEntity;

public interface CustomerController {
    ResponseEntity<CustomerModel> createCustomer(CustomerDto customerDto);
}
