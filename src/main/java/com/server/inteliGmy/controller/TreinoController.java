package com.server.inteliGmy.controller;

import com.server.inteliGmy.DTOs.ExercicioDTO;
import com.server.inteliGmy.DTOs.ExercicioDTOResponse;
import com.server.inteliGmy.DTOs.TreinoDTO;
import com.server.inteliGmy.DTOs.TreinoDTOResponse;
import com.server.inteliGmy.service.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treino")
public class TreinoController {

    @Autowired
    private TreinoService treinoService;

    @PostMapping()
    public ResponseEntity<Void> a(@RequestBody TreinoDTO treinoDTO) {
        treinoService.criarTreino(treinoDTO);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/{uidAluno}")
    public ResponseEntity<List<TreinoDTOResponse>> getTreinoByAluno(@PathVariable String uidAluno) {
        List<TreinoDTOResponse> treinos = treinoService.getTreinoByAluno(uidAluno);
        return ResponseEntity.ok().body(treinos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletTreino(@PathVariable Long id) {
        treinoService.deleteTreino(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/exercicio")
    public ResponseEntity<Void> adicionarExercicio(@PathVariable Long id, @RequestBody ExercicioDTO dto) {
        treinoService.adicionarExercicio(id, dto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/exercicios")
    public ResponseEntity<List<ExercicioDTOResponse>> getExerciciosByTreino(@PathVariable Long id) {
        List<ExercicioDTOResponse> dtos = treinoService.getExerciciosByTreino(id);
        return ResponseEntity.ok().body(dtos);
    }
}
