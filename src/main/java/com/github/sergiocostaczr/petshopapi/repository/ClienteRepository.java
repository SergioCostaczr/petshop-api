package com.github.sergiocostaczr.petshopapi.repository;

import com.github.sergiocostaczr.petshopapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
