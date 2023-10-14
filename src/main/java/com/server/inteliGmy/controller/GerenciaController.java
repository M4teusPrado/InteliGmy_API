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
    public ResponseEntity<Gerencia> getAGerenciaById(@PathVariable String uid) {
        return ResponseEntity.ok().body(gerenciaService.getGerencia(uid));
    }

    @GetMapping()
    public ResponseEntity<List<Gerencia>> getInstrutores() {
        return ResponseEntity.ok().body(gerenciaService.getGerentes());
    }


    @PutMapping("/{uid}")
    public ResponseEntity<Void> updateAdmin(@PathVariable String uid, @RequestBody Gerencia adminDTO) {
        Gerencia a = gerenciaService.updateEvent(uid, adminDTO);
        return ResponseEntity.noContent().build();

    }

    @PostMapping()
    public ResponseEntity<Gerencia> insertAdmin(@RequestBody Gerencia gerencia) {

        Gerencia aux = gerenciaService.insertGerencia(gerencia);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aux.getId()).toUri();
        return ResponseEntity.created(uri).body(aux);
    }


    @PostMapping("/{uid}/instrutor")
    public ResponseEntity<Instrutor> insertInstrutor(@PathVariable String uid, @RequestBody Instrutor instrutor) throws FirebaseAuthException {
        Instrutor aux = gerenciaService.insertInstrutor(uid, instrutor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aux.getId()).toUri();
        return ResponseEntity.created(uri).body(aux);
    }

    @GetMapping("/{uid}/instrutores")
    public ResponseEntity<List<Instrutor>> getInstrutoresByGerente(@PathVariable String uid) {
        return ResponseEntity.ok().body(gerenciaService.getInstrutores(uid));
    }

    @PutMapping("/{uid}/alunos/{uidAluno}")
    public ResponseEntity<Void> a(@PathVariable String uid, @PathVariable String uidAluno) {
        gerenciaService.b(uid, uidAluno);
        return ResponseEntity.noContent().build();

    }

}
