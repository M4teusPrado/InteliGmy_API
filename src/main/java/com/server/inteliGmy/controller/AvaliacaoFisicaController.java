package com.server.inteliGmy.controller;

import com.server.inteliGmy.DTOs.avaliacao.AgendamentoAvaliacaoFisicaDTO;
import com.server.inteliGmy.DTOs.avaliacao.AvaliacaoDTO;
import com.server.inteliGmy.DTOs.avaliacao.AvaliacaoFisicaResponseDTO;
import com.server.inteliGmy.service.AvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaService avaliacaoFisicaService;

    @PostMapping("/agendarAvaliacao")
    public ResponseEntity<Void> scheduleAvaliacaoFisicaForInstructor(@RequestBody AgendamentoAvaliacaoFisicaDTO agendamentoAvaliacaoFisicaDTO) {
        avaliacaoFisicaService.agendarAvaliacaoParaInstrutor(agendamentoAvaliacaoFisicaDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/buscarPorData")
    public ResponseEntity<List<AvaliacaoFisicaResponseDTO>> buscarAvaliacoesPorData(@RequestParam(value = "data", defaultValue = "") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data) {

        if (data == null) {
            data = LocalDate.now();
        }

        List<AvaliacaoFisicaResponseDTO> avaliacoes = avaliacaoFisicaService.buscarAvaliacoesPorData(data);
        return ResponseEntity.ok(avaliacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoFisicaResponseDTO> buscarAvaliacaoPorId(@PathVariable Long id) {
        AvaliacaoFisicaResponseDTO avaliacoes = avaliacaoFisicaService.buscarAvaliacaoById(id);
        return ResponseEntity.ok(avaliacoes);
    }

    @GetMapping("/alunos/{uidAluno}")
    public ResponseEntity<List<AvaliacaoFisicaResponseDTO>> buscarAvaliacoesPorAluno(@PathVariable String uidAluno) {
        List<AvaliacaoFisicaResponseDTO> avaliacoes = avaliacaoFisicaService.buscarAvaliacaoByAluno(uidAluno);
        return ResponseEntity.ok(avaliacoes);
    }

    @PostMapping("/avaliar")
    public ResponseEntity<Void> avaliarAvaliacaoFisica(@RequestBody AvaliacaoDTO avaliacaoDTO) {
        avaliacaoFisicaService.processarAvaliacaoFisica(avaliacaoDTO);
        return ResponseEntity.ok().build();
    }

}
