package com.server.inteliGmy.DTOs;

import com.server.inteliGmy.model.Aluno;

import java.time.LocalDate;
import java.time.LocalTime;

public class AvaliacaoFisicaResponseDTO {

    private Long id;
    private Long instrutorId;
    private Aluno aluno;
    private LocalDate dataAvaliacao;
    private LocalTime horarioAvaliacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInstrutorId() {
        return instrutorId;
    }

    public void setInstrutorId(Long instrutorId) {
        this.instrutorId = instrutorId;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public LocalDate getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDate dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public LocalTime getHorarioAvaliacao() {
        return horarioAvaliacao;
    }

    public void setHorarioAvaliacao(LocalTime horarioAvaliacao) {
        this.horarioAvaliacao = horarioAvaliacao;
    }
}
