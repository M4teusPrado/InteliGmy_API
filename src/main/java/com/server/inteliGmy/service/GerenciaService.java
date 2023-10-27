package com.server.inteliGmy.service;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.server.inteliGmy.model.Aluno;
import com.server.inteliGmy.model.Gerencia;
import com.server.inteliGmy.model.HorarioAlunos;
import com.server.inteliGmy.model.Instrutor;
import com.server.inteliGmy.repository.GerenciaRepository;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
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

        if (gerenciaDTO.getImgProfile() != null) {
            gerencia.setImgProfile(gerenciaDTO.getImgProfile());
        }

        saveGerencia(gerencia);
    }

    public Gerencia saveGerencia(Gerencia gerencia) {
        return gerenciaRepository.save(gerencia);
    }

    @Transactional
    public Instrutor insertInstrutor(String uidGerencia, Instrutor instrutor) throws FirebaseAuthException {
        Gerencia gerencia = getGerenciaById(uidGerencia);
        Instrutor savedInstrutor = insertInstrutorFirebase(instrutor);
        savedInstrutor = createInstrutor(savedInstrutor);
        associateInstrutorWithGerencia(savedInstrutor, gerencia);
        saveGerencia(gerencia);
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

    public List<HorarioAlunos> obterCurvaAlunosPorHora(String uidGerencia) {
        Gerencia gerencia = getGerenciaById(uidGerencia);
        return obterMediaUsuariosLogadosPorHorario(gerencia.getId());
    }

    public List<HorarioAlunos> obterMediaUsuariosLogadosPorHorario(Long idGerencia) {
        List<Tuple> resultados = gerenciaRepository.contarUsuariosLogadosPorHorario(idGerencia);
        return extrairHorarioAlunos(resultados);
    }

    public List<HorarioAlunos> extrairHorarioAlunos(List<Tuple> resultados) {
        List<Integer> horariosValidos = Arrays.asList(6, 8, 10, 12, 14, 16, 18, 20, 22);
        List<HorarioAlunos> listaObjetos = new ArrayList<>();

        for (Tuple resultado : resultados) {
            int horario = resultado.get(0, Integer.class);
            BigDecimal mediaUsuariosLogados = resultado.get(1, BigDecimal.class);

            if (horariosValidos.contains(horario)) {
                listaObjetos.add(new HorarioAlunos(horario, mediaUsuariosLogados));
            }
        }
        return listaObjetos;
    }
}


