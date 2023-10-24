package com.server.inteliGmy.DTOs;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.server.inteliGmy.helper.CustomLocalDateDeserializer;
import com.server.inteliGmy.helper.CustomLocalTimeDeserializer;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AvaliacaoFisicaDTO {

    private String uidInstrutor;
    private String uidAluno;

    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    private LocalDate dataAvaliacao;

    @JsonDeserialize(using = CustomLocalTimeDeserializer.class)
    private LocalTime horarioAvaliacao;
}
