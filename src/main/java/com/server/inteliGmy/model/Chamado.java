package com.server.inteliGmy.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.server.inteliGmy.helper.CustomLocalDateDeserializer;
import com.server.inteliGmy.model.Enuns.StatusChamados;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    private StatusChamados statusChamados;

    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    @Temporal(TemporalType.DATE) // Apenas a data
    private LocalDate dataCriacao;

    private LocalDate horarioConclusao;

    @ManyToOne
    private Instrutor instrutor;

}
