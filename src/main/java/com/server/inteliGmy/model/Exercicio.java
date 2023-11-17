package com.server.inteliGmy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.server.inteliGmy.model.Enuns.TipoExercicio;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer repeticoes;
    private Integer series;
    private Integer peso;
    private TipoExercicio tipo;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "treino_id")
    private Treino treino;
}
