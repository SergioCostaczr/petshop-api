package com.github.sergiocostaczr.petshopapi.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record ClienteResponseDTO(
        @Schema(description = "ID do cliente", example = "1")
        Long id,
        @Schema(description = "Nome do cliente", example = "João Silva")
        String nome,
        @Schema(description = "Telefone do cliente", example = "(85) 99999-9999")
        String telefone,
        @Schema(description = "Endereço do cliente", example = "Rua das Flores, 123, Fortaleza - CE")
        String endereco,
        @Schema(description = "Lista de pets do cliente")
        List<PetResponseDTO> petLista
) {
}
