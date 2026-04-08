package com.github.sergiocostaczr.petshopapi.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.UniqueElements;

public record ClienteRequestDTO(
        @NotBlank(message = "Nome é obrigatorio")
        String nome,
        @NotBlank(message = "Telefone é obrigatório")
        @UniqueElements(message = "Telefone já cadastrado")
        String telefone,
        @NotBlank(message = "Endereço é obrigatorio")
        String endereco

) {
}
