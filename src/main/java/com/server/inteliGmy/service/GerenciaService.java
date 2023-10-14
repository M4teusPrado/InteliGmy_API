package com.server.inteliGmy.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.server.inteliGmy.model.Aluno;
import com.server.inteliGmy.model.Gerencia;
import com.server.inteliGmy.model.Instrutor;
import com.server.inteliGmy.repository.GerenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.transaction.annotation.Transactional;

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
        return gerenciaRepository.findByUid(uid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Gerente não encontrado"));
    }

    @Transactional
    public Gerencia updateGerencia(String uid, Gerencia gerenciaDTO) {
        Gerencia gerencia = getGerenciaById(uid);

        if (gerenciaDTO.getNome() != null) {
            gerencia.setNome(gerenciaDTO.getNome());
        }

        return gerencia;
    }

    public Gerencia insertGerencia(Gerencia gerenciaDTO) {
        return gerenciaRepository.save(gerenciaDTO);
    }

    public Instrutor insertInstrutor(String uid, Instrutor instrutor) throws FirebaseAuthException {
        Gerencia gerencia = getGerenciaById(uid);

        instrutor.setUid(insertInstrutorFirebase(instrutor).getUid());
        Instrutor savedInstrutor = instrutorService.createInstrutor(instrutor);

        gerencia.addInstrutor(savedInstrutor);
        return savedInstrutor;
    }

    private UserRecord insertInstrutorFirebase(Instrutor instrutor) throws FirebaseAuthException {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(instrutor.getEmail())
                .setEmailVerified(false)
                .setPassword(instrutor.getSenhaTemporaria())
                .setDisplayName(instrutor.getNome())
                .setDisabled(false);

        return FirebaseAuth.getInstance().createUser(request);
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
