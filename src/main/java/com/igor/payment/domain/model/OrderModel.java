package com.igor.payment.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.igor.payment.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("orders")
public class OrderModel {
    @Id
    private String id;

    @NotBlank(message = "Customer deve ser informado no pedido")
    private String customerId;

    private BigDecimal originalPrice;

    private BigDecimal discount;

    @JsonIgnore
    private LocalDateTime dtRegistedOrder;

    @JsonProperty("product")
    private ProductDto product;
}
