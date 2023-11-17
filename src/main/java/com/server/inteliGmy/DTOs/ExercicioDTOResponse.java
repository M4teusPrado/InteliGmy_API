package com.server.inteliGmy.DTOs;

import lombok.Data;

@Data
public class ExercicioDTOResponse {

    private Long id;
    private String nome;
    private Integer repeticoes;
    private Integer series;
    private Integer peso;

}
