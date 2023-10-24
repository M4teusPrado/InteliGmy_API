package com.server.inteliGmy.controller;

import com.server.inteliGmy.DTOs.AvaliacaoFisicaDTO;
import com.server.inteliGmy.service.AvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaService avaliacaoFisicaService;

    @PostMapping("/agendarAvaliacao")
    public ResponseEntity<Void> scheduleAvaliacaoFisicaForInstructor(@RequestBody AvaliacaoFisicaDTO avaliacaoFisicaDTO) {
        avaliacaoFisicaService.agendarAvaliacaoParaInstrutor(avaliacaoFisicaDTO);
        return ResponseEntity.ok().build();
    }

}
