package com.igor.payment.domain.service.impl;

import com.igor.payment.domain.model.ProductModel;
import com.igor.payment.domain.repository.ProductRepository;
import com.igor.payment.domain.service.ProductService;
import com.igor.payment.dto.ProductDto;
import com.igor.payment.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public ProductModel create(ProductDto dto) {
        ProductModel model = ProductMapper.fromDtoToModel(dto);
        model.setDtCreation(LocalDate.now());
        return productRepository.save(model);
    }

    @Override
    public List<ProductModel> readAll() {
        return productRepository.findAll();
    }
}
