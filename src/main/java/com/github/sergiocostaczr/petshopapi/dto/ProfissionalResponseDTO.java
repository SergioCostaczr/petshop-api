package com.github.sergiocostaczr.petshopapi.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProfissionalResponseDTO(
        Long id,

        String nome,

        String funcao,

        BigDecimal Salario,

        LocalDateTime dataCadastro

) {
}
