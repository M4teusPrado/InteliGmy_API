package com.server.inteliGmy.controller;

import com.google.firebase.auth.FirebaseAuthException;
import com.server.inteliGmy.model.Gerencia;
import com.server.inteliGmy.model.Instrutor;
import com.server.inteliGmy.service.GerenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/owner")
public class GerenciaController {

    @Autowired
    private GerenciaService gerenciaService;

    @GetMapping("/{uid}")
    public ResponseEntity<Gerencia> getGerenciaById(@PathVariable String uid) {
        Gerencia gerencia = gerenciaService.getGerenciaById(uid);
        return ResponseEntity.ok().body(gerencia);
    }

    @GetMapping()
    public ResponseEntity<List<Gerencia>> getGerentes() {
        List<Gerencia> gerentes = gerenciaService.getGerentes();
        return ResponseEntity.ok().body(gerentes);
    }

    @PutMapping("/{uid}")
    public ResponseEntity<Void> updateGerencia(@PathVariable String uid, @RequestBody Gerencia gerenciaDTO) {
        gerenciaService.updateGerencia(uid, gerenciaDTO);
        return ResponseEntity.noContent().build();
    }

    @PostMapping()
    public ResponseEntity<Gerencia> insertGerencia(@RequestBody Gerencia gerencia) {
        Gerencia gerenciaInserida = gerenciaService.saveGerencia(gerencia);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(gerenciaInserida.getId()).toUri();
        return ResponseEntity.created(uri).body(gerenciaInserida);
    }

    @PostMapping("/{uid}/instrutor")
    public ResponseEntity<Instrutor> insertInstrutor(@PathVariable String uid, @RequestBody Instrutor instrutor) throws FirebaseAuthException {
        Instrutor instrutorInserido = gerenciaService.insertInstrutor(uid, instrutor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(instrutorInserido.getId()).toUri();
        return ResponseEntity.created(uri).body(instrutorInserido);
    }

    @GetMapping("/{uid}/instrutores")
    public ResponseEntity<List<Instrutor>> getInstrutoresByGerente(@PathVariable String uid) {
        List<Instrutor> instrutores = gerenciaService.getInstrutores(uid);
        return ResponseEntity.ok().body(instrutores);
    }

    @PutMapping("/{uid}/alunos/{uidAluno}")
    public ResponseEntity<Void> associateAlunoWithGerencia(@PathVariable String uid, @PathVariable String uidAluno) {
        gerenciaService.associateAlunoWithGerencia(uid, uidAluno);
        return ResponseEntity.noContent().build();
    }
}
