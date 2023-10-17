package com.igor.payment.domain.service.impl;

import com.igor.payment.domain.model.CustomerModel;
import com.igor.payment.domain.repository.CustomerRepository;
import com.igor.payment.domain.service.CustomerService;
import com.igor.payment.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.igor.payment.mapper.CustomerMapper.fromDtoToModel;
import static com.igor.payment.mapper.CustomerMapper.fromModelToModel;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public CustomerModel create(CustomerDto customerDto) {
        return customerRepository.findByEmail(customerDto.getEmail())
                .map(customerByEmail -> customerRepository.save(fromModelToModel(customerByEmail, customerDto)))
                .orElseGet(() -> customerRepository.save(fromDtoToModel(customerDto)));
    }
}
