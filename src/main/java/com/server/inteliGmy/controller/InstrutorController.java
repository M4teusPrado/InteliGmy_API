package com.server.inteliGmy.controller;

import com.server.inteliGmy.model.Aluno;
import com.server.inteliGmy.model.Instrutor;
import com.server.inteliGmy.service.InstrutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController {

    @Autowired
    private InstrutorService instrutorService;

    @GetMapping()
    public ResponseEntity<List<Instrutor>> getAGerenciaById() {
        return ResponseEntity.ok().body(instrutorService.getInstrutores());
    }

    @GetMapping("/{uidInstrutor}/alunos")
    public List<Aluno> retrieveSameManagementStudents(@PathVariable String uidInstrutor) {
        return instrutorService.findAlunosByInstrutorId(uidInstrutor);
    }
}
