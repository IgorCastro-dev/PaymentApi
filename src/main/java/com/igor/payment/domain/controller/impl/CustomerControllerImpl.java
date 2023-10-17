package com.igor.payment.domain.controller.impl;

import com.igor.payment.domain.model.CustomerModel;
import com.igor.payment.domain.service.CustomerService;
import com.igor.payment.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1/customer")
public class CustomerControllerImpl {

    @Autowired
    private CustomerService customerService;
    @PostMapping
    public ResponseEntity<CustomerModel> createCustomer(@Valid @RequestBody CustomerDto customerDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.customerService.create(customerDto));
    }
}
