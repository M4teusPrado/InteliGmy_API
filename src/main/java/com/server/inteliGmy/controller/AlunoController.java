package com.server.inteliGmy.controller;

import com.server.inteliGmy.model.Aluno;
import com.server.inteliGmy.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping()
    public ResponseEntity<Aluno> createAluno(@RequestBody Aluno aluno) {

        Aluno aux = alunoService.createAluno(aluno);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aux.getId()).toUri();
        return ResponseEntity.created(uri).body(aux);
    }

    @GetMapping("/{uid}")
    public ResponseEntity<Aluno> getAlunoById(@PathVariable String uid) {
        return ResponseEntity.ok().body(alunoService.getAlunoById(uid));
    }


}
