package com.server.inteliGmy.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.server.inteliGmy.model.Gerencia;
import com.server.inteliGmy.model.Instrutor;
import com.server.inteliGmy.repository.GerenciaRepository;
import com.server.inteliGmy.repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerenciaService {

    @Autowired
    private GerenciaRepository gerenciaRepository;

    @Autowired
    private InstrutorRepository instrutorRepository;

    public Gerencia getGerencia(String uid) {
        return gerenciaRepository.findByUid(uid);
    }

    public Gerencia updateEvent(String uid, Gerencia gerenciaDTO) {
        Gerencia gerencia = getGerencia(uid);

        if (gerenciaDTO.getNome() != null) {
            gerencia.setNome(gerenciaDTO.getNome());
        }

        return gerenciaRepository.save(gerencia);
    }

    public Gerencia insertGerencia(Gerencia gerenciaDTO) {
        return gerenciaRepository.save(gerenciaDTO);
    }

    public Instrutor insertInstrutor(String uid, Instrutor instrutor) throws FirebaseAuthException {
        Gerencia gerencia = getGerencia(uid);

        instrutor.setUid(insertInstrutorFirebase(instrutor).getUid());

        Instrutor savedInstrutor = instrutorRepository.save(instrutor);

        gerencia.addInstrutor(savedInstrutor);
        gerenciaRepository.save(gerencia);

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
        return  getGerencia(uidGerente).getInstrutores();
    }
}
