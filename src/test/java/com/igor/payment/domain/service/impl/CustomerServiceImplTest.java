package com.igor.payment.domain.service.impl;

import com.igor.payment.domain.model.CustomerModel;
import com.igor.payment.domain.repository.CustomerRepository;
import com.igor.payment.dto.CustomerDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {
    @InjectMocks
    private CustomerServiceImpl customerService;
    @Mock
    private CustomerRepository customerRepository;
    @Test
    void give_create_when_customerByEmailIsPresent_then_returnCustomerModel() {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setEmail("t@test.com");
        CustomerModel customerModel = new CustomerModel();
        Mockito.when(customerRepository.findByEmail("t@test.com")).thenReturn(Optional.of(customerModel));
        Mockito.when(customerRepository.save(customerModel)).thenReturn(customerModel);
        Assertions.assertEquals(customerModel,customerService.create(customerDto));
        Mockito.verify(customerRepository,Mockito.times(1)).findByEmail("t@test.com");
        Mockito.verify(customerRepository,Mockito.times(1)).save(customerModel);
    }
}