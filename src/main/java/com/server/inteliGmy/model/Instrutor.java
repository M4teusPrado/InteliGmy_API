package com.server.inteliGmy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Instrutor {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String uid;
    private String nome;
    private String email;
    private String dataNascimento;
    private String sexo;
    private String horario;
    private String senhaTemporaria;



}
