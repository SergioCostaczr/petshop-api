package com.github.sergiocostaczr.petshopapi.repository;

import com.github.sergiocostaczr.petshopapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
