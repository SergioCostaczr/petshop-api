package com.github.sergiocostaczr.petshopapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record PetRequestDTO(
        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 3,max = 40)
        String nome,

        @NotBlank(message = "A raca é obrigatória")
        @Size(min = 3,max = 30)
        String raca,

        LocalDate dataNascimento,

        @NotNull(message = "Id do dono é obrigatório")
        Long idCliente
) {
}
