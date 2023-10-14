package com.server.inteliGmy.service;

import com.server.inteliGmy.model.Aluno;
import com.server.inteliGmy.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno createAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno getAlunoById(String uid) {
        Optional<Aluno> gerente = alunoRepository.findByUid(uid);
        gerente.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));
        return gerente.get();
    }
}
