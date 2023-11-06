package com.server.inteliGmy.DTOs;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.server.inteliGmy.helper.CustomLocalDateDeserializer;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TreinoDTO {

    private String uidInstrutor;
    private String uidAluno;

    private String nomeTreino;
    private String objetivo;

    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    private LocalDate dataInicio;

    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    private LocalDate dataFim;
}
