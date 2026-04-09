package com.github.sergiocostaczr.petshopapi.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProfissionalResponseDTO(
        @Schema(description = "ID do profissional", example = "1")
        Long id,
        @Schema(description = "Nome do profissional", example = "Maria Souza")
        String nome,
        @Schema(description = "Função do profissional", example = "Veterinário")
        String funcao,
        @Schema(description = "Salário do profissional", example = "3500.00")
        BigDecimal salario,
        @Schema(description = "Data de cadastro do profissional", example = "2024-01-15T10:30:00")
        LocalDateTime dataCadastro

) {
}
