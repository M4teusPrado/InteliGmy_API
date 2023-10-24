package com.server.inteliGmy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.server.inteliGmy.model.Enuns.Nivel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Instrutor extends BaseUser {

    private String horario;
    private String senhaTemporaria;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gerencia_id")
    private Gerencia gerente;


    @OneToMany(mappedBy = "instrutor", cascade = CascadeType.ALL)
    private List<AvaliacaoFisica> agendamentos;


    @Override
    public void setNivel(Nivel nivel) {
        super.setNivel(Nivel.INSTRUTOR);
    }

    @Override
    public String toString() {
        return "Instrutor{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                // Não inclua a referência ao AgendamentoAvaliacao aqui
                '}';
    }
}
