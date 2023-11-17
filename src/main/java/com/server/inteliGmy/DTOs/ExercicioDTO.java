package com.server.inteliGmy.DTOs;

import com.server.inteliGmy.model.Enuns.TipoExercicio;
import lombok.Data;

@Data
public class ExercicioDTO {

    private String nome;
    private Integer repeticoes;
    private Integer series;
    private Integer peso;
    private TipoExercicio tipoExercicio;
}
