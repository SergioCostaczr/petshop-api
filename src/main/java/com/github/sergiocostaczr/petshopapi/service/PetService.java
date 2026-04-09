package com.github.sergiocostaczr.petshopapi.service;

import com.github.sergiocostaczr.petshopapi.dto.request.PetRequestDTO;
import com.github.sergiocostaczr.petshopapi.dto.response.PetResponseDTO;
import com.github.sergiocostaczr.petshopapi.entity.Cliente;
import com.github.sergiocostaczr.petshopapi.entity.Pet;
import com.github.sergiocostaczr.petshopapi.repository.ClienteRepository;
import com.github.sergiocostaczr.petshopapi.repository.PetRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    @Autowired
    ClienteRepository clienteRepository;


    public PetResponseDTO salvar(PetRequestDTO dto){
        Pet pet = new Pet();
        Cliente cliente = clienteRepository.findById(dto.idCliente()).orElseThrow(() -> new EntityNotFoundException());

        dtoParaEntidade(pet,dto,cliente);

        Pet entidadeSalva = repository.save(pet);

        return entidadeParaResponseDTO(entidadeSalva);

    }

    public PetResponseDTO buscarPorId(Long id){
        Pet petEncontrado = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pet não encontrado"));
        return entidadeParaResponseDTO(petEncontrado);
    }

    public PetResponseDTO atualizarPorId(Long id, PetRequestDTO dto){
        Pet petEncontrado = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pet não encontrado"));

        Cliente clienteEncontrado = clienteRepository.findById(dto.idCliente()).orElseThrow(() -> new EntityNotFoundException("Dono do Pet não encontrado"));

        dtoParaEntidade(petEncontrado, dto, clienteEncontrado);

        Pet petAtualizado = repository.save(petEncontrado);

        return entidadeParaResponseDTO(petAtualizado);
    }

    public List<PetResponseDTO> listar(){
        List<Pet> lista = repository.findAll();

        return lista.stream().map(x-> entidadeParaResponseDTO(x)).toList();

    }

    public void deletarPorId(Long id){
        repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pet não encontrado"));
        repository.deleteById(id);
    }
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
