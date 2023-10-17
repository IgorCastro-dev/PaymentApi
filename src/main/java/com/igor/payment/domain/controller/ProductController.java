package com.igor.payment.domain.controller;

import com.igor.payment.core.swagger.SwaggerConfig;
import com.igor.payment.domain.model.ProductModel;
import com.igor.payment.dto.ProductDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Api(tags = SwaggerConfig.PRODUCT)
public interface ProductController {
    @ApiOperation(value = "Criar novo produto")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Produto com sucesso"),
            @ApiResponse(code = 400, message = "Erro ao criar produto"),
            @ApiResponse(code = 500, message = "Erro interno no serviço"),
    })
    ResponseEntity<ProductModel> create(@Valid @RequestBody ProductDto dto);

    @ApiOperation(value = "Lista todos os produtos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso na consulta"),
            @ApiResponse(code = 500, message = "Erro interno no serviço"),
    })
    ResponseEntity<List<ProductModel>> readAll();
}
