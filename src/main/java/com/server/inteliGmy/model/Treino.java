package com.server.inteliGmy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.server.inteliGmy.helper.CustomLocalDateDeserializer;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String objetivo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "instrutor_id")
    private Instrutor instrutor;

    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    @Temporal(TemporalType.DATE)
    private LocalDate dataInicio;

    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    @Temporal(TemporalType.DATE)
    private LocalDate dataFim;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "treino")
    private List<Exercicio> exercicioList = new ArrayList<>();

    public void addExercicio(Exercicio exercicio) {
        exercicioList.add(exercicio);
    }


    @Override
    public String toString() {
        return "Treino{" +
                "id=" + id +
                // Adicione outras propriedades do Treino conforme necessário
                '}';
    }
}
