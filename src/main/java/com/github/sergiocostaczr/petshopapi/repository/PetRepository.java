package com.github.sergiocostaczr.petshopapi.repository;

import com.github.sergiocostaczr.petshopapi.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
