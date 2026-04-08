package com.github.sergiocostaczr.petshopapi.repository;

import com.github.sergiocostaczr.petshopapi.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
