package com.github.sergiocostaczr.petshopapi.controller;

import com.github.sergiocostaczr.petshopapi.dto.request.LoginRequest;
import com.github.sergiocostaczr.petshopapi.dto.request.RegisterRequest;
import com.github.sergiocostaczr.petshopapi.dto.response.AuthResponse;
import com.github.sergiocostaczr.petshopapi.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/registrar")
    public ResponseEntity<AuthResponse> registrar(@RequestBody @Valid RegisterRequest req){
        return ResponseEntity.ok(authService.registrar(req));
    }

    @GetMapping("/login")
    public ResponseEntity<AuthResponse> login (@RequestBody @Valid LoginRequest req){
        return ResponseEntity.ok(authService.login(req));
    }
}
