package com.server.inteliGmy.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.server.inteliGmy.model.Aluno;
import com.server.inteliGmy.model.Instrutor;
import com.server.inteliGmy.repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrutorService {

    @Autowired
    private InstrutorRepository instrutorRepository;

    public List<Instrutor> getInstrutores() {
        return instrutorRepository.findAll();
    }

    public Instrutor createInstrutor(Instrutor instrutor) {
        return instrutorRepository.save(instrutor);
    }

    public List<Aluno> findAlunosByInstrutorId(String uidInstrutor) {
        return instrutorRepository.findAlunosByInstrutorId(uidInstrutor);
    }

    public UserRecord insertInstrutorFirebase(Instrutor instrutor) throws FirebaseAuthException {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(instrutor.getEmail())
                .setEmailVerified(false)
                .setPassword(instrutor.getSenhaTemporaria())
                .setDisplayName(instrutor.getNome())
                .setDisabled(false);

        return FirebaseAuth.getInstance().createUser(request);
    }
}
