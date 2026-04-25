package com.github.sergiocostaczr.petshopapi.dto.request;

import com.github.sergiocostaczr.petshopapi.model.Pet;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AgendamentoRequestDTO(
        @NotNull
        Long petId,

        @NotNull
        Long profissionalId,

        @NotNull
        @Future
        LocalDateTime dataHora,

        String observacoes

) {
}
