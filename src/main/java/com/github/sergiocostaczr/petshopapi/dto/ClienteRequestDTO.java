package com.github.sergiocostaczr.petshopapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.UniqueElements;

public record ClienteRequestDTO(
        @Schema(description = "Nome completo do cliente", example = "João Silva")
        @NotBlank(message = "Nome é obrigatorio")
        String nome,

        @Schema(description = "Telefone do cliente", example = "(85) 99999-9999")
        @NotBlank(message = "Telefone é obrigatório")
        String telefone,

        @Schema(description = "Endereço do cliente", example = "Rua das Flores, 123, Fortaleza - CE")
        @NotBlank(message = "Endereço é obrigatorio")
        String endereco

) {
}
