package com.igor.payment.domain.service;

import com.igor.payment.domain.model.ProductModel;
import com.igor.payment.dto.ProductDto;
import java.util.List;

public interface ProductService {
    ProductModel create(ProductDto dto);

    List<ProductModel> readAll();
}
