package com.github.sergiocostaczr.petshopapi.dto;

import com.github.sergiocostaczr.petshopapi.entity.Pet;

import java.util.List;

public record ClienteResponseDTO(
        Long id,
        String nome,
        String telefone,
        String endereco,
        List<Pet> petLista
) {
}
