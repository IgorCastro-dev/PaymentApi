package com.igor.payment.domain.controller;

import com.igor.payment.core.swagger.SwaggerConfig;
import com.igor.payment.dto.PaymentDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Api(tags = SwaggerConfig.PAYMENT)
public interface PaymentController {
    @ApiOperation(value = "Cadastrar um novo cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Customer criado ou atualizado com sucesso"),
            @ApiResponse(code = 400, message = "Erro na requisição enviada pelo cliente"),
            @ApiResponse(code = 500, message = "Erro interno no serviço"),
    })
    ResponseEntity<Boolean> process(@Valid @RequestBody PaymentDto dto);
}


