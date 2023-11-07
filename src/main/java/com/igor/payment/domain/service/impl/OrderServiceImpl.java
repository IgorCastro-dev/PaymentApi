package com.igor.payment.domain.service.impl;

import com.igor.payment.domain.model.CustomerModel;
import com.igor.payment.domain.model.OrderModel;
import com.igor.payment.domain.model.ProductModel;
import com.igor.payment.domain.repository.CustomerRepository;
import com.igor.payment.domain.repository.OrderRepository;
import com.igor.payment.domain.repository.ProductRepository;
import com.igor.payment.domain.service.OrderService;
import com.igor.payment.dto.OrderDto;
import com.igor.payment.dto.ProductDto;
import com.igor.payment.exception.BusinessException;
import com.igor.payment.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Optional;
import static com.igor.payment.mapper.OrderMapper.fromDtoToModel;
import static com.igor.payment.mapper.ProductMapper.fromModelToDto;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public OrderModel create(OrderDto orderDto){
        Optional<CustomerModel> customerModelOpt = customerRepository.findById(orderDto.getCustomerId());

        if (customerModelOpt.isEmpty()) {
            throw new NotFoundException("Cliete não encontrado");
        }

        Optional<ProductModel> productModelOpt = productRepository.findByAcronym(orderDto.getProductAcronym().toUpperCase());
        if (productModelOpt.isEmpty()) {
            throw new NotFoundException("Sigla do produto inexistente");
        }
        ProductDto productDto = fromModelToDto(productModelOpt.get());
        OrderModel orderModel = fromDtoToModel(orderDto, productDto);
        if (orderDto.getDiscount().intValue() > 0) {
            if (orderDto.getDiscount().compareTo(productModelOpt.get().getCurrentPrice()) > 0) {
                throw new BusinessException("Desconto não pode ser maior que o valor original", HttpStatus.BAD_REQUEST);
            }
            orderModel.setOriginalPrice(productModelOpt.get().getCurrentPrice().subtract(orderDto.getDiscount()));
        }

        return orderRepository.save(orderModel);
    }
}
