package com.github.sergiocostaczr.petshopapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public record PetResponseDTO(
        @Schema(description = "ID do pet", example = "1")
        Long id,
        @Schema(description = "Nome do pet", example = "Rex")
        String nome,
        @Schema(description = "Raça do pet", example = "Golden Retriever")
        String raca,
        @Schema(description = "Data de nascimento do pet", example = "2021-05-10")
        LocalDate dataNascimento,
        @Schema(description = "ID do cliente dono do pet", example = "1")
        Long idCliente
) {
}
