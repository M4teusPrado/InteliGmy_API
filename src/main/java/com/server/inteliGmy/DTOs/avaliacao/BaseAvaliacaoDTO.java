package com.server.inteliGmy.DTOs.avaliacao;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.server.inteliGmy.helper.CustomLocalDateDeserializer;
import com.server.inteliGmy.helper.CustomLocalTimeDeserializer;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public abstract class BaseAvaliacaoDTO {

    private String uidInstrutor;
    private String uidAluno;

    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    private LocalDate dataAvaliacao;

    @JsonDeserialize(using = CustomLocalTimeDeserializer.class)
    private LocalTime horarioAvaliacao;
}
