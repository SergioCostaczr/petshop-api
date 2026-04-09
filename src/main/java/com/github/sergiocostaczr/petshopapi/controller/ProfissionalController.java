package com.github.sergiocostaczr.petshopapi.controller;

import com.github.sergiocostaczr.petshopapi.dto.ProfissionalRequestDTO;
import com.github.sergiocostaczr.petshopapi.dto.ProfissionalResponseDTO;
import com.github.sergiocostaczr.petshopapi.service.ProfissionalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profissionais")
@Tag(name = "Profissionais", description = "Gerenciamento de profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalService service;


    @PostMapping
    @Operation(summary = "Cadastrar profissional")
    @ApiResponses({ @ApiResponse(responseCode = "201", description = "Cadastrado com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos") })
    public ResponseEntity<ProfissionalResponseDTO> salvar(@RequestBody @Valid ProfissionalRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @GetMapping("{id}")
    @Operation(summary = "Buscar profissional por ID")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Profissional encontrado"),
                    @ApiResponse(responseCode = "404", description = "Não encontrado") })
    public ResponseEntity<?> buscarPorId(@Parameter(description = "ID do profissional") @PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.buscarPorId(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    @Operation(summary = "Atualizar profissional por ID")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Atualizado com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Não encontrado") })
    public ResponseEntity<?> atualizarPorId(@Parameter(description = "ID do profissional") @PathVariable Long id, @RequestBody @Valid ProfissionalRequestDTO dto) {
        try {
            return ResponseEntity.ok(service.atualizarPorId(id, dto));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    @Operation(summary = "Listar todos os profissionais")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Deletar profissional por ID")
    @ApiResponses({ @ApiResponse(responseCode = "204", description = "Deletado com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Não encontrado") })
    public ResponseEntity<?> deletarPorId(@Parameter(description = "ID do profissional") @PathVariable Long id){
        try {
            service.deletarPorId(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}