package com.igor.payment.domain.controller;

import com.igor.payment.core.swagger.SwaggerConfig;
import com.igor.payment.domain.model.CustomerModel;
import com.igor.payment.dto.CustomerDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

@Api(tags = SwaggerConfig.CUSTOMER)
public interface CustomerController {
    @ApiOperation(value = "Cadastrar um novo cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Customer criado ou atualizado com sucesso"),
            @ApiResponse(code = 400, message = "Erro na requisição enviada pelo cliente"),
            @ApiResponse(code = 500, message = "Erro interno no serviço"),
    })
    ResponseEntity<CustomerModel> createCustomer(CustomerDto customerDto);
}
