package com.github.sergiocostaczr.petshopapi.service;

import com.github.sergiocostaczr.petshopapi.dto.request.ClienteRequestDTO;
import com.github.sergiocostaczr.petshopapi.dto.response.ClienteResponseDTO;
import com.github.sergiocostaczr.petshopapi.dto.response.PetResponseDTO;
import com.github.sergiocostaczr.petshopapi.entity.Cliente;
import com.github.sergiocostaczr.petshopapi.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public ClienteResponseDTO salvar(ClienteRequestDTO dto){
        Cliente cliente = new Cliente();
        dtoParaEntidade(cliente,dto);

        Cliente entidadeSalva = repository.save(cliente);

        return entidadeParaResponseDTO(entidadeSalva);

    }

    public ClienteResponseDTO buscarPorId(Long id){
        Cliente clienteEncontrado = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        return entidadeParaResponseDTO(clienteEncontrado);
    }

    public ClienteResponseDTO atualizarPorId(Long id, ClienteRequestDTO dto){
        Cliente clienteEncontrado = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        dtoParaEntidade(clienteEncontrado,dto);

        Cliente clienteAtualizado = repository.save(clienteEncontrado);

        return entidadeParaResponseDTO(clienteAtualizado);
    }

    public List<ClienteResponseDTO> listar(){
        List<Cliente> lista = repository.findAll();

        return lista.stream().map(x-> entidadeParaResponseDTO(x)).toList();

    }

    public void deletarPorId(Long id){
        repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        repository.deleteById(id);
    }

    private void dtoParaEntidade(Cliente entidade, ClienteRequestDTO dto ){
        entidade.setNome(dto.nome());
        entidade.setEndereco(dto.endereco());
        entidade.setTelefone(dto.telefone());
    }

    private ClienteResponseDTO entidadeParaResponseDTO(Cliente cliente){
        List<PetResponseDTO> pets = cliente.getPetLista() == null
                ? new ArrayList<>()
                : cliente.getPetLista().stream()
                .map(pet -> new PetResponseDTO(
                        pet.getId(),
                        pet.getNome(),
                        pet.getRaca(),
                        pet.getDataNascimento(),
                        pet.getClinte().getId()
                ))
                .toList();

        return new ClienteResponseDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getTelefone(),
                cliente.getEndereco(),
                pets
        );
    }

}
