package com.server.inteliGmy.controller;

import com.server.inteliGmy.DTOs.ChamadoDTO;
import com.server.inteliGmy.DTOs.FeedbackDTO;
import com.server.inteliGmy.DTOs.SolicitacaoChamadoDTO;
import com.server.inteliGmy.service.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {

    @Autowired
    private ChamadoService chamadoService;

    @PostMapping("/solicitar")
    public ResponseEntity<Void> solicitarChamado(@RequestBody SolicitacaoChamadoDTO solicitacaoChamadoDTO) {
        chamadoService.solicitarChamado(solicitacaoChamadoDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/registrarFeedback")
    public ResponseEntity<Void> registrarFeedback(@RequestBody FeedbackDTO feedbackDTO) {
        chamadoService.registrarFeedback(feedbackDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/instrutor/{uidInstrutor}")
    public ResponseEntity<List<ChamadoDTO>> getChamadosByInstrutor(@PathVariable String uidInstrutor) {
        List<ChamadoDTO> chamados = chamadoService.findChamadosDTOByInstrutorUid(uidInstrutor);
        return ResponseEntity.ok().body(chamados);
    }


    @PutMapping("/{id}/concluir")
    public ResponseEntity<Void> concluirChamado(@PathVariable Long id) {
        chamadoService.concluirChamado(id);
        return ResponseEntity.noContent().build();
    }
}
