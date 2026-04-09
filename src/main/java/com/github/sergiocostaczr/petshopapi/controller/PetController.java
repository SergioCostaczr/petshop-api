package com.github.sergiocostaczr.petshopapi.controller;

import com.github.sergiocostaczr.petshopapi.dto.PetRequestDTO;
import com.github.sergiocostaczr.petshopapi.dto.PetResponseDTO;
import com.github.sergiocostaczr.petshopapi.service.PetService;
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
@RequestMapping("/pets")
@Tag(name = "Pets", description = "Gerenciamento de pets")
public class PetController {

    @Autowired
    private PetService service;


    @PostMapping
    @Operation(summary = "Cadastrar pet")
    @ApiResponses({ @ApiResponse(responseCode = "201", description = "Cadastrado com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos"),
                    @ApiResponse(responseCode = "404", description = "Cliente dono não encontrado")})
    public ResponseEntity<?> salvar(@RequestBody @Valid PetRequestDTO dto) {
        try {
            PetResponseDTO salvar = service.salvar(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}")
    @Operation(summary = "Buscar pet por ID")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Pet encontrado"),
                    @ApiResponse(responseCode = "404", description = "Não encontrado") })
    public ResponseEntity<?> buscarPorId(@Parameter(description = "ID do pet") @PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.buscarPorId(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    @Operation(summary = "Atualizar pet por ID")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Atualizado com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Não encontrado") })
    public ResponseEntity<?> atualizarPorId(@Parameter(description = "ID do pet") @PathVariable Long id, @RequestBody @Valid PetRequestDTO dto) {
        try {
            return ResponseEntity.ok(service.atualizarPorId(id, dto));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    @Operation(summary = "Listar todos os pets")

    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Deletar pet por ID")
    @ApiResponses({ @ApiResponse(responseCode = "204", description = "Deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Não encontrado") })
    public ResponseEntity<?> deletarPorId(@Parameter(description = "ID do pet") @PathVariable Long id) {
        try {
            service.deletarPorId(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
