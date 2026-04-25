package com.github.sergiocostaczr.petshopapi.repository;

import com.github.sergiocostaczr.petshopapi.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>  {

    boolean existsByProfissionalIdAndDataHora(Long profissionalId, LocalDateTime dataHora);
}
