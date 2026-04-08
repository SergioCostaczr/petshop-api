package com.github.sergiocostaczr.petshopapi.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProfissionalRequestDTO(

        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 3,max = 100)
        String nome,

        @NotBlank(message = "A função é obrigatória")
        @Size(min = 3,max = 100)
        String funcao,

        @NotNull(message = "Salário é obrigatório")
        @Digits(integer = 4,fraction = 2)
        BigDecimal salario
) {
}
