package com.server.inteliGmy.service;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.server.inteliGmy.model.Aluno;
import com.server.inteliGmy.model.Gerencia;
import com.server.inteliGmy.model.Instrutor;
import com.server.inteliGmy.repository.GerenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GerenciaService {

    @Autowired
    private GerenciaRepository gerenciaRepository;

    @Autowired
    private InstrutorService instrutorService;

    @Autowired
    private AlunoService alunoService;

    public Gerencia getGerenciaById(String uid) {
        return gerenciaRepository.findByUid(uid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Gerente não encontrado"));
    }

    @Transactional
    public void updateGerencia(String uid, Gerencia gerenciaDTO) {
        Gerencia gerencia = getGerenciaById(uid);

        if (gerenciaDTO.getNome() != null) {
            gerencia.setNome(gerenciaDTO.getNome());
        }
    }

    public Gerencia insertGerencia(Gerencia gerencia) {
        return gerenciaRepository.save(gerencia);
    }

    @Transactional
    public Instrutor insertInstrutor(String uidGerencia, Instrutor instrutor) throws FirebaseAuthException {
        Gerencia gerencia = getGerenciaById(uidGerencia);
        Instrutor savedInstrutor = insertInstrutorFirebase(instrutor);
        savedInstrutor = createInstrutor(savedInstrutor);
        associateInstrutorWithGerencia(savedInstrutor, gerencia);
        updateGerenciaWithNewInstrutor(gerencia);

        return savedInstrutor;
    }

    private Instrutor insertInstrutorFirebase(Instrutor instrutor) throws FirebaseAuthException {
        UserRecord savedInstrutor = instrutorService.insertInstrutorFirebase(instrutor);
        instrutor.setUid(savedInstrutor.getUid());
        return instrutor;
    }

    private Instrutor createInstrutor(Instrutor instrutor) {
        return instrutorService.saveInstrutor(instrutor);
    }

    private void associateInstrutorWithGerencia(Instrutor instrutor, Gerencia gerencia) {
        gerencia.addInstrutor(instrutor);
        instrutor.setGerente(gerencia);
    }

    private void updateGerenciaWithNewInstrutor(Gerencia gerencia) {
        insertGerencia(gerencia);
    }

    public List<Instrutor> getInstrutores(String uidGerente) {
        return getGerenciaById(uidGerente).getInstrutores();
    }

    public List<Gerencia> getGerentes() {
        return gerenciaRepository.findAll();
    }

    @Transactional
    public void associateAlunoWithGerencia(String uid, String uidAluno) {
        Gerencia gerencia = getGerenciaById(uid);
        Aluno aluno = alunoService.getAlunoById(uidAluno);
        gerencia.addAluno(aluno);
    }
}
