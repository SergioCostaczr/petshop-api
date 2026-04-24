package com.github.sergiocostaczr.petshopapi.service;

import com.github.sergiocostaczr.petshopapi.dto.request.LoginRequest;
import com.github.sergiocostaczr.petshopapi.dto.request.RegisterRequest;
import com.github.sergiocostaczr.petshopapi.dto.response.AuthResponse;
import com.github.sergiocostaczr.petshopapi.exception.EmailJaCadastradoException;
import com.github.sergiocostaczr.petshopapi.jwt.JwtService;
import com.github.sergiocostaczr.petshopapi.model.Usuario;
import com.github.sergiocostaczr.petshopapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthResponse registrar(RegisterRequest req){
        usuarioRepository.findByEmail(req.email())
                .ifPresent(a-> {
            throw new EmailJaCadastradoException("Email já cadastrado");
                });

        Usuario usuario = new Usuario();
        usuario.setEmail(req.email());
        usuario.setSenha(passwordEncoder.encode(req.senha()));
        usuario.setRole(req.role());

        usuarioRepository.save(usuario);
        return new AuthResponse(jwtService.gerarToken(usuario));
    }

    public AuthResponse login(LoginRequest req){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.email(),req.senha())
        );
        var usuario = usuarioRepository.findByEmail(req.email()).orElseThrow(() -> new UsernameNotFoundException("Usuario ou senha Incorreto"));
        return new AuthResponse(jwtService.gerarToken(usuario));
    }

}
