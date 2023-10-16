package com.igor.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {
    private String id;

    @NotBlank(message = "firstName é obrigatório")
    private String firstName;

    @NotBlank(message = "lastName é obrigatório")
    private String lastName;

    @Email(message = "email precisa ser válido")
    private String email;

    @NotBlank(message = "cpf deve ser preenchido")
    @CPF(message = "cpf precisa ser valido")
    private String cpf;
}
