package com.github.sergiocostaczr.petshopapi.service;

import com.github.sergiocostaczr.petshopapi.dto.ProfissionalRequestDTO;
import com.github.sergiocostaczr.petshopapi.dto.ProfissionalResponseDTO;
import com.github.sergiocostaczr.petshopapi.entity.Profissional;
import com.github.sergiocostaczr.petshopapi.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfissionalService {
    @Autowired
    private ProfissionalRepository repository;

    private void dtoParaEntidade(ProfissionalRequestDTO dto, Profissional profissional){
        profissional.setNome(dto.nome());
        profissional.setFuncao(dto.funcao());
        profissional.setSalario(dto.salario());
    }

    private ProfissionalResponseDTO entidadeParaResponseDto(Profissional entidade){
        return new ProfissionalResponseDTO(
                entidade.getId(),
                entidade.getNome(),
                entidade.getFuncao(),
                entidade.getSalario(),
                entidade.getDataCadastro()
        );
    }
}
