package com.github.sergiocostaczr.petshopapi.dto.request;

import com.github.sergiocostaczr.petshopapi.model.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterRequest (
        @Email
        @NotBlank
        String email,

        @NotBlank
        String senha,

        @NotNull
        Role role
){
}
