package com.server.inteliGmy.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.server.inteliGmy.model.Aluno;
import com.server.inteliGmy.model.Instrutor;
import com.server.inteliGmy.repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class InstrutorService {

    @Autowired
    private InstrutorRepository instrutorRepository;

    public Instrutor getInstrutorById(String uid) {
        return instrutorRepository.findByUid(uid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Gerente não encontrado"));
    }

    public List<Instrutor> getInstrutores() {
        return instrutorRepository.findAll();
    }

    public Instrutor saveInstrutor(Instrutor instrutor) {
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

    public void deleteInstrutor(String uidInstrutor) {
        Instrutor instrutor = getInstrutorById(uidInstrutor);
        instrutorRepository.deleteById(instrutor.getId());
    }

    @Transactional
    public void updateInstrutor(String uidInstrutor, Instrutor instrutorDTO) {

        Instrutor instrutor = getInstrutorById(uidInstrutor);

        if (instrutorDTO.getNome() != null) {
            instrutor.setNome(instrutorDTO.getNome());
        }

        if (instrutorDTO.getImgProfile() != null) {
            instrutor.setImgProfile(instrutorDTO.getImgProfile());
        }

        saveInstrutor(instrutor);
    }
}
