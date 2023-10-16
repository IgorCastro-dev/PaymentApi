package com.igor.payment.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("products")
public class ProductModel {
    @Id
    private String id;

    @Indexed(unique = true)
    @Size(min = 6,max = 20)
    private String acronym;

    @NotBlank
    private String name;

    @NotNull
    private BigDecimal currentPrice;

    @NotNull
    @JsonIgnore
    private LocalDate dtCreation = LocalDate.now();
}
