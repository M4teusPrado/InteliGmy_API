package com.server.inteliGmy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.server.inteliGmy.model.Enuns.Nivel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Aluno extends BaseUser {

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gerencia_id")
    private Gerencia gerente;

    @Lob
    private byte[] imgProfile;

    @JsonIgnore()
    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<Avaliacao> agendamentos;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "aluno")
    private List<Treino> treinos;

    @Override
    public void setNivel(Nivel nivel) {
        super.setNivel(Nivel.ALUNO);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                // Não inclua a referência ao AgendamentoAvaliacao aqui
                '}';
    }
}
