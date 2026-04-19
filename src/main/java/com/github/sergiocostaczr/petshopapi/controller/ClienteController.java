package com.github.sergiocostaczr.petshopapi.controller;

import com.github.sergiocostaczr.petshopapi.dto.request.ClienteRequestDTO;
import com.github.sergiocostaczr.petshopapi.dto.response.ClienteResponseDTO;
import com.github.sergiocostaczr.petshopapi.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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
@RequestMapping("/clientes")
@Tag(name = "Clientes", description = "Gerenciamento de clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;


    @PostMapping
    @Operation(summary = "Cadastrar cliente")
    @ApiResponses({ @ApiResponse(responseCode = "201", description = "Cadastrado com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos") })
    public ResponseEntity<ClienteResponseDTO> salvar(@RequestBody @Valid ClienteRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @GetMapping("{id}")
    @Operation(summary = "Buscar cliente por ID")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Cliente encontrado",
                                 content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteResponseDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Não encontrado") })
    public ResponseEntity<?> buscarPorId(@Parameter(description = "ID do cliente") @PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("{id}")
    @Operation(summary = "Atualizar cliente por ID")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Atualizado com sucesso",
                                 content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteResponseDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Não encontrado") })
    public ResponseEntity<?> atualizarPorId(@Parameter(description = "ID do cliente") @PathVariable Long id, @RequestBody @Valid ClienteRequestDTO dto) {
        return ResponseEntity.ok(service.atualizarPorId(id, dto));
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
        service.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}