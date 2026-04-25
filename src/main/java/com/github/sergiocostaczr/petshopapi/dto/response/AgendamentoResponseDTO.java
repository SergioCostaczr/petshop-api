package com.github.sergiocostaczr.petshopapi.dto.response;

import com.github.sergiocostaczr.petshopapi.model.enums.StatusAgendamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AgendamentoResponseDTO (
        Long id,

        Long petId,
        String petNome,

        Long profissionalId,
        String profissionalNome,

        LocalDateTime dataHora,
        BigDecimal valorServico,
        String observacoes,
        StatusAgendamento status
){
}
