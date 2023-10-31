package com.server.inteliGmy.DTOs;

import com.server.inteliGmy.model.Aluno;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ChamadoDTO {
    private Long id;
    private Aluno aluno;
    private LocalDate dataCriacao;
    private LocalDateTime horarioConclusao;
}
