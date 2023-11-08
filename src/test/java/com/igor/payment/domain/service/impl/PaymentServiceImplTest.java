package com.igor.payment.domain.service.impl;

import com.igor.payment.domain.model.CreditCardModel;
import com.igor.payment.domain.model.CustomerModel;
import com.igor.payment.domain.model.OrderModel;
import com.igor.payment.domain.repository.CreditCardRepository;
import com.igor.payment.domain.repository.CustomerRepository;
import com.igor.payment.domain.repository.OrderRepository;
import com.igor.payment.dto.CreditCardDto;
import com.igor.payment.dto.PaymentDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PaymentServiceImplTest {
    @InjectMocks
    private PaymentServiceImpl paymentService;
    @Mock
    private CreditCardRepository creditCardRepository;
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private OrderRepository orderRepository;

    @Test
    void give_process_whenPaymentIsOk_thenReturnTrue() {
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setCustomerId("1");
        paymentDto.setOrderId("1");
        CreditCardDto creditCardDto = new CreditCardDto();
        creditCardDto.setNumber("123123123123");
        paymentDto.setCreditCard(creditCardDto);
        OrderModel orderModel = new OrderModel();
        CustomerModel customerModel = new CustomerModel();
        Optional<CustomerModel> customerModelOptional = Optional.of(customerModel);
        customerModel.setCpf("15570378900");
        CreditCardModel creditCardModel = new CreditCardModel();
        creditCardModel.setCustomerId("1");
        creditCardModel.setDocumentNumber("15570378900");
        Mockito.when(orderRepository.findById("1")).thenReturn(Optional.of(orderModel));
        Mockito.when(customerRepository.findById("1")).thenReturn(customerModelOptional);
        Mockito.when(creditCardRepository.findByNumber("123123123123")).thenReturn(List.of(creditCardModel));
        Assertions.assertTrue(paymentService.process(paymentDto));
        Mockito.verify(orderRepository).findById("1");
        Mockito.verify(customerRepository).findById("1");
        Mockito.verify(creditCardRepository).findByNumber("123123123123");
    }
}




















