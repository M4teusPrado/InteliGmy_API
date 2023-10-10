package com.server.inteliGmy.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Gerencia {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String uid;
    private String nome;
    private String nomeAcademia;
    private String email;
    private String cnpj;
    private String senha;

    @OneToMany
    private List<Instrutor> instrutors;


    public void addInstrutor(Instrutor instrutor) {

        this.instrutors.add(instrutor);
    }

}
