package com.server.inteliGmy.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.server.inteliGmy.helper.CustomLocalDateDeserializer;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String objetivo;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "instrutor_id")
    private Instrutor instrutor;

    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    @Temporal(TemporalType.DATE)
    private LocalDate dataInicio;

    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    @Temporal(TemporalType.DATE)
    private LocalDate dataFim;
}
