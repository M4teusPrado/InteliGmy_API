package com.server.inteliGmy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class AvaliacaoFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double altura;
    private Double peso;
    private Double imc;
    private Double gorduraCorporal;
    private Double gorduraVisceral;
    private Double antebracoEsquerdo;
    private Double antebracoDireito;
    private Double bracoEsquerdo;
    private Double bracoDireito;
    private Double coxaEsquerda;
    private Double coxaDireita;
    private Double panturrilhaEsquerda;
    private Double panturrilhaDireita;
    private Double cintura;
    private Double abdomen;
    private Double quadril;

}
