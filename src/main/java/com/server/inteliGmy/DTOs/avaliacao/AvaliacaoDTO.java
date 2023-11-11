package com.server.inteliGmy.DTOs.avaliacao;

import com.server.inteliGmy.model.AvaliacaoFisica;
import lombok.Data;

@Data
public class AvaliacaoDTO extends BaseAvaliacaoDTO {
    private Long idAvaliacao;
    private AvaliacaoFisica avaliacaoFisica;
}
