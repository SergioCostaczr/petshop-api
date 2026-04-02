package com.github.sergiocostaczr.petshopapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "profissionais")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String profissao;

    @Column(nullable = false)
    private Double salario;

    @CreatedDate
    @Column
    private LocalDateTime dataCadastro;

}
