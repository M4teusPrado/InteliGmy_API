package com.server.inteliGmy.DTOs;

import lombok.Data;

@Data
public class FeedbackDTO {
    private String uidAlunoAvaliador;
    private String uidInstrutorAvaliado;
    private Double classificacao;
    private String comentario;
}
