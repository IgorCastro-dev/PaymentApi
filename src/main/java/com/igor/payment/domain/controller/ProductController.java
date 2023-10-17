package com.igor.payment.domain.controller;

import com.igor.payment.domain.model.ProductModel;
import com.igor.payment.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface ProductController {
    ResponseEntity<ProductModel> create(@Valid @RequestBody ProductDto dto);
    ResponseEntity<List<ProductModel>> readAll();
}
