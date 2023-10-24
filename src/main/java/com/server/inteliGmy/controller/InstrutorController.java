package com.server.inteliGmy.controller;

import com.server.inteliGmy.model.Aluno;
import com.server.inteliGmy.model.Instrutor;
import com.server.inteliGmy.service.InstrutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/{uidInstrutor}")
    public ResponseEntity<Void> deleteInstrutor(@PathVariable String uidInstrutor) {
        instrutorService.deleteInstrutor(uidInstrutor);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{uidInstrutor}")
    public ResponseEntity<Instrutor> getInstrutorById(@PathVariable String uidInstrutor) {
        Instrutor instrutor = instrutorService.getInstrutorById(uidInstrutor);
        return ResponseEntity.ok().body(instrutor);
    }

    @PutMapping("/{uidInstrutor}")
    public ResponseEntity<Void> updateInstrutor(@PathVariable String uidInstrutor, @RequestBody Instrutor instrutorDTO) {
        instrutorService.updateInstrutor(uidInstrutor, instrutorDTO);
        return ResponseEntity.noContent().build();
    }
}
