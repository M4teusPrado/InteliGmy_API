package com.server.inteliGmy.model;


import com.server.inteliGmy.model.Enuns.Nivel;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Gerencia extends BaseUser {

    private String nomeAcademia;
    private String cnpj;
    private String senha;
    @OneToMany
    private List<Instrutor> instrutores;
    @OneToMany
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
