package com.server.inteliGmy.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class HorarioAlunos {

    private int horario;
    private BigDecimal mediaUsuariosLogados;

    public HorarioAlunos(int horario, BigDecimal mediaAlunos) {
        this.horario = horario;
        this.mediaUsuariosLogados = mediaAlunos;
    }
}