package com.github.sergiocostaczr.petshopapi.controller;

import com.github.sergiocostaczr.petshopapi.dto.request.AgendamentoRequestDTO;
import com.github.sergiocostaczr.petshopapi.dto.response.AgendamentoResponseDTO;
import com.github.sergiocostaczr.petshopapi.service.AgendamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;


    @PostMapping()
    public ResponseEntity<AgendamentoResponseDTO> agendar(@RequestBody @Valid AgendamentoRequestDTO requestDTO){
        return ResponseEntity.ok(agendamentoService.agendar(requestDTO));
    }
}
