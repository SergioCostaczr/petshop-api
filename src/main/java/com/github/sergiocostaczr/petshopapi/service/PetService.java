package com.github.sergiocostaczr.petshopapi.service;

import com.github.sergiocostaczr.petshopapi.dto.PetRequestDTO;
import com.github.sergiocostaczr.petshopapi.dto.PetResponseDTO;
import com.github.sergiocostaczr.petshopapi.entity.Cliente;
import com.github.sergiocostaczr.petshopapi.entity.Pet;
import com.github.sergiocostaczr.petshopapi.repository.PetRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    private void dtoParaEntidade(Pet petEntidade, PetRequestDTO dto, Cliente cliente){
        petEntidade.setNome(dto.nome());
        petEntidade.setRaca(dto.raca());
        petEntidade.setDataNascimento(dto.dataNascimento());
        petEntidade.setClinte(cliente);
    }

    private PetResponseDTO entidadeParaResponseDTO(Pet entidade){
        return  new PetResponseDTO(
                entidade.getId(),
                entidade.getNome(),
                entidade.getRaca(),
                entidade.getDataNascimento(),
                entidade.getClinte().getId()
        );
    }
}
