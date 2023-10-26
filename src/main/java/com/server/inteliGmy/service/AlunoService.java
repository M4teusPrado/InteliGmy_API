package com.server.inteliGmy.service;

import com.server.inteliGmy.model.Aluno;
import com.server.inteliGmy.model.Gerencia;
import com.server.inteliGmy.model.Instrutor;
import com.server.inteliGmy.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno createAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno getAlunoById(String uid) {
        Optional<Aluno> gerente = alunoRepository.findByUid(uid);
        gerente.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));
        return gerente.get();
    }

    @Transactional
    public void updateAluno(String uid, Aluno alunoDTO) {
        Aluno gerencia = getAlunoById(uid);

        if (alunoDTO.getNome() != null) {
            gerencia.setNome(alunoDTO.getNome());
        }

        if (alunoDTO.getEmail() != null) {
            gerencia.setEmail(alunoDTO.getEmail());
        }

        alunoRepository.save(gerencia);

    }


    //TODO: Criar uma consulta personalizada para simplificar este método
    public List<Instrutor> getInstrutoressByAlunoId(String uidAluno) {

        Optional<Aluno> alunoOptional = alunoRepository.findByUid(uidAluno);

        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            Gerencia gerencia = aluno.getGerente();

            if (gerencia != null) {
                return gerencia.getInstrutores();
            }
        }

        return Collections.emptyList();
    }
}
