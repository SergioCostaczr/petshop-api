package com.github.sergiocostaczr.petshopapi.service;

import com.github.sergiocostaczr.petshopapi.dto.ProfissionalRequestDTO;
import com.github.sergiocostaczr.petshopapi.dto.ProfissionalResponseDTO;
import com.github.sergiocostaczr.petshopapi.entity.Profissional;
import com.github.sergiocostaczr.petshopapi.repository.ProfissionalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfissionalService {
    @Autowired
    private ProfissionalRepository repository;

    public ProfissionalResponseDTO salvar(ProfissionalRequestDTO dto){
        Profissional entidade = new Profissional();
        dtoParaEntidade(dto,entidade);
        Profissional entidadeSalva = repository.save(entidade);
        return entidadeParaResponseDto(entidadeSalva);
    }

    public ProfissionalResponseDTO buscarPorId(Long id){
        Profissional profissional = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Profissional não entcontrado"));

        return entidadeParaResponseDto(profissional);
    }

    public ProfissionalResponseDTO atualizarPorId(Long id, ProfissionalRequestDTO dto){
        Profissional entidade = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Profissional não entcontrado"));
        dtoParaEntidade(dto,entidade);

        Profissional entidadeAtualizada = repository.save(entidade);

        return entidadeParaResponseDto(entidadeAtualizada);

    }

    public List<ProfissionalResponseDTO> listar(){
        List<Profissional> lista = repository.findAll();

        return lista.stream().map(x -> entidadeParaResponseDto(x)).toList();

    }

    public void deletarPorId(Long id){
        Profissional entidade = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Profissional não entcontrado"));
        repository.deleteById(id);
    }

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
