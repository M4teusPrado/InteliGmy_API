package com.server.inteliGmy.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.server.inteliGmy.helper.CustomLocalDateDeserializer;
import com.server.inteliGmy.model.Enuns.StatusChamados;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    private StatusChamados statusChamados;

    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    @Temporal(TemporalType.DATE) // Apenas a data
    private LocalDate dataCriacao;

    private LocalDate dataConclusao;
    private LocalDateTime horarioConclusao;

    @ManyToOne
    private Instrutor instrutor;

}
