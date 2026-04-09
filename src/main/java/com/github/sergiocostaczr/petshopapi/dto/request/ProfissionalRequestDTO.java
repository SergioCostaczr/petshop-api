package com.github.sergiocostaczr.petshopapi.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProfissionalRequestDTO(

        @Schema(description = "Nome do profissional", example = "Maria Souza")
        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 3,max = 100)
        String nome,

        @Schema(description = "Função do profissional", example = "Veterinário")
        @NotBlank(message = "A função é obrigatória")
        @Size(min = 3,max = 100)
        String funcao,

        @Schema(description = "Salário do profissional", example = "3500.00")
        @NotNull(message = "Salário é obrigatório")
        @Digits(integer = 4,fraction = 2)
        BigDecimal salario
) {
}
