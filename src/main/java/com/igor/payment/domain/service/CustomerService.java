package com.igor.payment.domain.service;

import com.igor.payment.domain.model.CustomerModel;
import com.igor.payment.dto.CustomerDto;

public interface CustomerService {
    CustomerModel create(CustomerDto customerDto);
}
