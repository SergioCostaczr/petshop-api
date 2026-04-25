package com.github.sergiocostaczr.petshopapi.service;

import com.github.sergiocostaczr.petshopapi.dto.request.AgendamentoRequestDTO;
import com.github.sergiocostaczr.petshopapi.dto.response.AgendamentoResponseDTO;
import com.github.sergiocostaczr.petshopapi.exception.BusinessException;
import com.github.sergiocostaczr.petshopapi.model.Agendamento;
import com.github.sergiocostaczr.petshopapi.model.Pet;
import com.github.sergiocostaczr.petshopapi.model.Profissional;
import com.github.sergiocostaczr.petshopapi.model.enums.StatusAgendamento;
import com.github.sergiocostaczr.petshopapi.repository.AgendamentoRepository;
import com.github.sergiocostaczr.petshopapi.repository.PetRepository;
import com.github.sergiocostaczr.petshopapi.repository.ProfissionalRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final PetRepository petRepository;
    private final ProfissionalRepository profissionalRepository;

    @Transactional
    public AgendamentoResponseDTO agendar(AgendamentoRequestDTO dto){
        Pet pet = petRepository.findById(dto.petId()).orElseThrow(()-> new EntityNotFoundException("Pet não encontrado"));
        Profissional prof = profissionalRepository.findById(dto.profissionalId()).orElseThrow(()-> new EntityNotFoundException("Profissional não encontrado"));

        if (dto.dataHora().getHour() < 8 || dto.dataHora().getHour() > 18){
            throw new BusinessException("Horário fora do período de funcionamento (08h às 18h)");
        }

        boolean ocupado = agendamentoRepository.existsByProfissionalIdAndDataHora(
                dto.profissionalId(),
                dto.dataHora()
        );

        if (ocupado) {
            throw new BusinessException("O profissional já possui um agendamento para este horário.");
        }

        Agendamento agenda = new Agendamento();
        agenda.setPet(pet);
        agenda.setProfissional(prof);
        agenda.setDataHora(dto.dataHora());
        agenda.setValorServico(prof.getSalario());
        agenda.setObservacoes(dto.observacoes());
        agenda.setStatus(StatusAgendamento.AGENDADO);

        Agendamento agendado = agendamentoRepository.save(agenda);

        return entidadeParaDto(agendado);

    }

    private AgendamentoResponseDTO entidadeParaDto(Agendamento agendamento){
        return new AgendamentoResponseDTO(
                agendamento.getId(),
                agendamento.getPet().getId(),
                agendamento.getPet().getNome(),
                agendamento.getProfissional().getId(),
                agendamento.getProfissional().getNome(),
                agendamento.getDataHora(),
                agendamento.getValorServico(),
                agendamento.getObservacoes(),
                agendamento.getStatus()
        );
    }

}
