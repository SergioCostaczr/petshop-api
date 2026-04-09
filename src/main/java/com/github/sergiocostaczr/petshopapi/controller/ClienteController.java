package com.github.sergiocostaczr.petshopapi.controller;

import com.github.sergiocostaczr.petshopapi.dto.ClienteRequestDTO;
import com.github.sergiocostaczr.petshopapi.dto.ClienteResponseDTO;
import com.github.sergiocostaczr.petshopapi.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
@Tag(name = "Clientes", description = "Gerenciamento de clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;


    @PostMapping
    @Operation(summary = "Cadastrar cliente")
    @ApiResponses({ @ApiResponse(responseCode = "201", description = "Cadastrado com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos") })
    public ResponseEntity<ClienteResponseDTO> salvar(@RequestBody ClienteRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @GetMapping("{id}")
    @Operation(summary = "Buscar cliente por ID")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Cliente encontrado"),
                    @ApiResponse(responseCode = "404", description = "Não encontrado") })
    public ResponseEntity<?> buscarPorId(@Parameter(description = "ID do cliente") @PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.buscarPorId(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    @Operation(summary = "Atualizar cliente por ID")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Atualizado com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Não encontrado") })
    public ResponseEntity<?> atualizarPorId(@Parameter(description = "ID do cliente") @PathVariable Long id, @RequestBody ClienteRequestDTO dto) {
        try {
            return ResponseEntity.ok(service.atualizarPorId(id, dto));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    @Operation(summary = "Listar todos os clientes")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Deletar cliente por ID")
    @ApiResponses({ @ApiResponse(responseCode = "204", description = "Deletado com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Não encontrado") })
    public ResponseEntity<?> deletarPorId(@PathVariable Long id) {
        try {
            service.deletarPorId(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}