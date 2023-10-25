package com.server.inteliGmy.controller;

import com.server.inteliGmy.DTOs.FeedbackDTO;
import com.server.inteliGmy.DTOs.SolicitacaoChamadoDTO;
import com.server.inteliGmy.service.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
