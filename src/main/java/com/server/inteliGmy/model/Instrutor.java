package com.server.inteliGmy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Lob
    private byte[] imgProfile;

    private Double mediaAvaliacao;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gerencia_id")
    private Gerencia gerente;

    @JsonIgnore()
    @OneToMany(mappedBy = "instrutor", cascade = CascadeType.REMOVE)
    private List<Chamado> chamados;

    @JsonIgnore()
    @OneToMany(mappedBy = "instrutorAvaliado", cascade = CascadeType.REMOVE)
    private List<Feedback> feedbacks;

    @JsonIgnore()
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
