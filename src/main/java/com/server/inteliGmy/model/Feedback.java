package com.server.inteliGmy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Instrutor instrutorAvaliado;

    @ManyToOne
    private Aluno alunoAvaliador;

    private Double classificacao;
    private String comentario;
    private LocalDate dataCriacao;
}