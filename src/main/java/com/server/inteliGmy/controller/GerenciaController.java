package com.server.inteliGmy.controller;

import com.server.inteliGmy.model.Gerencia;
import com.server.inteliGmy.service.GerenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/owner")
public class GerenciaController {

    @Autowired
    private GerenciaService gerenciaService;

    @GetMapping()
    public String teste() {
        return "Teste";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gerencia> getAGerenciaById(@PathVariable Long id ) {
        return ResponseEntity.ok().body(gerenciaService.getGerencia(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Gerencia> updateAdmin(@PathVariable Long id, @RequestBody Gerencia adminDTO)
    {
        Gerencia a = gerenciaService.updateEvent(id, adminDTO);
        return ResponseEntity.ok().body(a);
    }
}
