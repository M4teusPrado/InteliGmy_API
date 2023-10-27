package com.server.inteliGmy.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.server.inteliGmy.model.Enuns.Nivel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Gerencia extends BaseUser {

    private String nomeAcademia;
    private String cnpj;
    private String senha;

    @Lob
    private byte[] imgProfile;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "gerente")
    private List<Instrutor> instrutores;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "gerente")
    private List<Aluno> alunos;

    @Override
    public void setNivel(Nivel nivel) {
        super.setNivel(Nivel.GERENTE);
    }

    public void addInstrutor(Instrutor instrutor) {
        this.instrutores.add(instrutor);
    }

    public void addAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }
}
