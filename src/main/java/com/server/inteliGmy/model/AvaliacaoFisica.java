package com.server.inteliGmy.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.server.inteliGmy.helper.CustomLocalDateDeserializer;
import com.server.inteliGmy.helper.CustomLocalTimeDeserializer;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
public class AvaliacaoFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "instrutor_id") // Nome da coluna que faz a relação com o Instrutor
    private Instrutor instrutor;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    @Temporal(TemporalType.DATE) // Apenas a data
    private LocalDate dataAvaliacao;

    @JsonDeserialize(using = CustomLocalTimeDeserializer.class)
    private LocalTime horarioAvaliacao;

}