package com.igor.payment.domain.service.impl;

import com.igor.payment.domain.model.CreditCardModel;
import com.igor.payment.domain.repository.CreditCardRepository;
import com.igor.payment.domain.repository.CustomerRepository;
import com.igor.payment.domain.repository.OrderRepository;
import com.igor.payment.domain.service.PaymentService;
import com.igor.payment.dto.PaymentDto;
import com.igor.payment.exception.BusinessException;
import com.igor.payment.exception.NotFoundException;
import com.igor.payment.mapper.CreditCardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private CreditCardRepository creditCardRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Boolean process(PaymentDto paymentDto) {
        if (orderRepository.findById(paymentDto.getOrderId()).isEmpty()) {
            throw new NotFoundException("Pedido não encontrado");
        }

        var customer = customerRepository.findById(paymentDto.getCustomerId());
        if (customer.isEmpty()) {
            throw new NotFoundException("Cliente não encontrado");
        }

        var ccList = creditCardRepository.findByNumber(paymentDto.getCreditCard().getNumber());
        CreditCardModel ccModel = CreditCardMapper.fromDtoToModel(paymentDto.getCreditCard(), paymentDto.getCustomerId());
        if (ccList.isEmpty()) {
            creditCardRepository.save(ccModel);
        } else {
            ccList.forEach(creditCardModel -> {
                if (!creditCardModel.getCustomerId().equals(paymentDto.getCustomerId()) &&
                        !creditCardModel.getDocumentNumber().equals(customer.get().getCpf())) {
                    throw new BusinessException("Pagamento negado pela processadora", HttpStatus.UNAUTHORIZED);
                } else if (!creditCardModel.getCustomerId().equals(paymentDto.getCustomerId()) &&
                        creditCardModel.getDocumentNumber().equals(customer.get().getCpf())) {
                    creditCardRepository.save(ccModel);
                }
            });

        }
        return true;
    }
}
