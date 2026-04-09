package com.github.sergiocostaczr.petshopapi.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record PetRequestDTO(

        @Schema(description = "Nome do pet", example = "Rex")
        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 3,max = 40)
        String nome,

        @Schema(description = "Raça do pet", example = "Golden Retriever")
        @NotBlank(message = "A raca é obrigatória")
        @Size(min = 3,max = 30)
        String raca,

        @Schema(description = "Data de nascimento do pet", example = "2021-05-10")
        LocalDate dataNascimento,

        @Schema(description = "ID do cliente dono do pet", example = "1")
        @NotNull(message = "Id do dono é obrigatório")
        Long idCliente
) {
}
