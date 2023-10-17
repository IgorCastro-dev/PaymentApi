package com.igor.payment.domain.controller.impl;

import com.igor.payment.domain.model.ProductModel;
import com.igor.payment.domain.service.ProductService;
import com.igor.payment.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductControllerImpl {
    @Autowired
    private ProductService productService;
    @PostMapping()
    public ResponseEntity<ProductModel> create(@Valid @RequestBody ProductDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(dto));
    }

    @GetMapping()
    public ResponseEntity<List<ProductModel>> readAll() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.readAll());
    }
}
