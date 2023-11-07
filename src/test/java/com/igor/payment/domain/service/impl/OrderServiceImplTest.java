package com.igor.payment.domain.service.impl;

import com.igor.payment.domain.model.CustomerModel;
import com.igor.payment.domain.model.OrderModel;
import com.igor.payment.domain.model.ProductModel;
import com.igor.payment.domain.repository.CustomerRepository;
import com.igor.payment.domain.repository.OrderRepository;
import com.igor.payment.domain.repository.ProductRepository;
import com.igor.payment.dto.OrderDto;
import com.igor.payment.exception.BusinessException;
import com.igor.payment.exception.NotFoundException;
import com.igor.payment.mapper.OrderMapper;
import com.igor.payment.mapper.ProductMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.util.Optional;
@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {
    @InjectMocks
    private OrderServiceImpl orderService;
    @Mock
    private OrderMapper orderMapper;
    @Mock
    private ProductMapper productMapper;
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private ProductRepository productRepository;
    @Test
    void give_create_when_customerIsPresentAndProductIsPresentAndDiscountEqualZero_then_returnOrder(){
        OrderDto orderDto = new OrderDto();
        orderDto.setCustomerId("1");
        orderDto.setProductAcronym("MEN123");
        orderDto.setDiscount(BigDecimal.ZERO);
        CustomerModel customerModel = new CustomerModel();
        OrderModel orderModel = new OrderModel();
        ProductModel productModel = new ProductModel();
        productModel.setAcronym(orderDto.getProductAcronym());
        Mockito.when(customerRepository.findById(orderDto.getCustomerId())).thenReturn(Optional.of(customerModel));
        Mockito.when(productRepository.findByAcronym(orderDto.getProductAcronym())).thenReturn(Optional.of(productModel));
        Mockito.when(orderRepository.save(Mockito.any(OrderModel.class))).thenReturn(orderModel);
        Assertions.assertEquals(orderModel,orderService.create(orderDto));
        Mockito.verify(customerRepository,Mockito.times(1)).findById(orderDto.getCustomerId());
        Mockito.verify(productRepository,Mockito.times(1)).findByAcronym(orderDto.getProductAcronym());
        Mockito.verify(orderRepository,Mockito.times(1)).save(Mockito.any(OrderModel.class));
    }

    @Test
    void give_create_when_customerIsNotPresent_then_returnNotFoundException(){
        OrderDto orderDto = new OrderDto();
        Mockito.when(customerRepository.findById(orderDto.getCustomerId())).thenReturn(Optional.empty());
        Assertions.assertThrows(NotFoundException.class,()->orderService.create(orderDto));
    }
    @Test
    void give_create_when_productIsNotPresent_then_returnNotFoundException(){
        OrderDto orderDto = new OrderDto();
        orderDto.setCustomerId("1");
        orderDto.setProductAcronym("MEN123");
        orderDto.setDiscount(BigDecimal.ZERO);
        CustomerModel customerModel = new CustomerModel();
        Mockito.when(customerRepository.findById(orderDto.getCustomerId())).thenReturn(Optional.of(customerModel));
        Mockito.when(productRepository.findByAcronym(orderDto.getProductAcronym())).thenReturn(Optional.empty());
        Assertions.assertThrows(NotFoundException.class,()->orderService.create(orderDto));
        Mockito.verify(customerRepository,Mockito.times(1)).findById(orderDto.getCustomerId());
    }
    @Test
    void give_create_when_discountMoreThanZero_then_returnOrder(){
        OrderDto orderDto = new OrderDto();
        orderDto.setCustomerId("1");
        orderDto.setProductAcronym("MEN123");
        orderDto.setDiscount(BigDecimal.ONE);
        CustomerModel customerModel = new CustomerModel();
        OrderModel orderModel = new OrderModel();
        ProductModel productModel = new ProductModel();
        productModel.setCurrentPrice(BigDecimal.TEN);
        productModel.setAcronym(orderDto.getProductAcronym());
        Mockito.when(customerRepository.findById(orderDto.getCustomerId())).thenReturn(Optional.of(customerModel));
        Mockito.when(productRepository.findByAcronym(orderDto.getProductAcronym())).thenReturn(Optional.of(productModel));
        Mockito.when(orderRepository.save(Mockito.any(OrderModel.class))).thenReturn(orderModel);
        Assertions.assertEquals(orderModel,orderService.create(orderDto));
        Mockito.verify(customerRepository,Mockito.times(1)).findById(orderDto.getCustomerId());
        Mockito.verify(productRepository,Mockito.times(1)).findByAcronym(orderDto.getProductAcronym());
        Mockito.verify(orderRepository,Mockito.times(1)).save(Mockito.any(OrderModel.class));
    }

    @Test
    void give_create_when_discountMoreThanPrice_then_returnBusinessException(){
        OrderDto orderDto = new OrderDto();
        orderDto.setCustomerId("1");
        orderDto.setProductAcronym("MEN123");
        orderDto.setDiscount(BigDecimal.TEN);
        CustomerModel customerModel = new CustomerModel();
        ProductModel productModel = new ProductModel();
        productModel.setCurrentPrice(BigDecimal.ONE);
        productModel.setAcronym(orderDto.getProductAcronym());
        Mockito.when(customerRepository.findById(orderDto.getCustomerId())).thenReturn(Optional.of(customerModel));
        Mockito.when(productRepository.findByAcronym(orderDto.getProductAcronym())).thenReturn(Optional.of(productModel));
        Assertions.assertThrows(BusinessException.class,()->orderService.create(orderDto));
        Mockito.verify(customerRepository,Mockito.times(1)).findById(orderDto.getCustomerId());
        Mockito.verify(productRepository,Mockito.times(1)).findByAcronym(orderDto.getProductAcronym());
    }
}