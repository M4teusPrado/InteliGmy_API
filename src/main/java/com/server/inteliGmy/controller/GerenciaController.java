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

@RestController
@RequestMapping("/owner")
public class GerenciaController {

    @Autowired
    private GerenciaService gerenciaService;

    @GetMapping()
    public String teste() {
        return "Teste";
    }

    @GetMapping("/{uid}")
    public ResponseEntity<Gerencia> getAGerenciaById(@PathVariable String uid) {
        return ResponseEntity.ok().body(gerenciaService.getGerencia(uid));
    }

    @PutMapping("/{uid}")
    public ResponseEntity<Gerencia> updateAdmin(@PathVariable String uid, @RequestBody Gerencia adminDTO) {
        Gerencia a = gerenciaService.updateEvent(uid, adminDTO);
        return ResponseEntity.ok().body(a);
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
}
