package com.server.inteliGmy.service;

import com.server.inteliGmy.DTOs.FeedbackDTO;
import com.server.inteliGmy.DTOs.SolicitacaoChamadoDTO;
import com.server.inteliGmy.model.Aluno;
import com.server.inteliGmy.model.Chamado;
import com.server.inteliGmy.model.Enuns.StatusChamados;
import com.server.inteliGmy.model.Feedback;
import com.server.inteliGmy.model.Instrutor;
import com.server.inteliGmy.repository.ChamadoRepository;
import com.server.inteliGmy.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private InstrutorService instrutorService;

    @Autowired
    private AlunoService alunoService;

    public ChamadoService(ChamadoRepository chamadoRepository, FeedbackRepository feedbackRepository, InstrutorService instrutorService, AlunoService alunoService) {
        this.chamadoRepository = chamadoRepository;
        this.feedbackRepository = feedbackRepository;
        this.instrutorService = instrutorService;
        this.alunoService = alunoService;
    }


    public void solicitarChamado(SolicitacaoChamadoDTO chamadoDTO) {
        Instrutor instrutor = instrutorService.getInstrutorById(chamadoDTO.getUidInstrutor());
        Aluno aluno = alunoService.getAlunoById(chamadoDTO.getUidAluno());

        Chamado chamado = new Chamado();
        chamado.setInstrutor(instrutor);
        chamado.setAluno(aluno);
        chamado.setDataCriacao(LocalDate.now());
        chamado.setStatusChamados(StatusChamados.ABERTO);

        chamadoRepository.save(chamado);
    }

    public void registrarFeedback(FeedbackDTO feedbackDTO) {
        Instrutor instrutor = instrutorService.getInstrutorById(feedbackDTO.getUidInstrutorAvaliado());
        Aluno aluno = alunoService.getAlunoById(feedbackDTO.getUidAlunoAvaliador());

        Feedback feedback = new Feedback();
        feedback.setAlunoAvaliador(aluno);
        feedback.setInstrutorAvaliado(instrutor);
        feedback.setClassificacao(feedbackDTO.getClassificacao());
        feedback.setComentario(feedbackDTO.getComentario());
        feedback.setDataCriacao(LocalDate.now());

        feedbackRepository.save(feedback);
    }
}
