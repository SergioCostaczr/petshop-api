package com.github.sergiocostaczr.petshopapi.dto;

import java.time.LocalDate;

public record PetResponseDTO(
        Long id,
        String nome,
        String raca,
        LocalDate dataNascimento,
        Long idCliente
) {
}
