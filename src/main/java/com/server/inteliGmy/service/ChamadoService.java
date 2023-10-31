package com.server.inteliGmy.service;

import com.server.inteliGmy.DTOs.ChamadoDTO;
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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        atualizarMediaAvaliacao(instrutor);
    }

    public void atualizarMediaAvaliacao(Instrutor instrutor) {
        Double media = feedbackRepository.calcularMediaClassificacaoPorInstrutor(instrutor.getId());
        instrutor.setMediaAvaliacao(media);
        instrutorService.saveInstrutor(instrutor);
    }

    public List<ChamadoDTO> findChamadosDTOByInstrutorUid(String uid) {
        List<Chamado> chamados = chamadoRepository.findChamadosAbertosByInstrutorUid(uid);
        List<ChamadoDTO> chamadoDTOs = new ArrayList<>();

        for (Chamado chamado : chamados) {
            ChamadoDTO chamadoDTO = new ChamadoDTO();
            chamadoDTO.setId(chamado.getId());

            chamadoDTO.setDataCriacao(chamado.getDataCriacao());
            chamadoDTO.setHorarioConclusao(chamado.getHorarioConclusao());

            Aluno aluno = alunoService.getAlunoById(chamado.getAluno().getUid());
            chamadoDTO.setAluno(aluno);

            chamadoDTOs.add(chamadoDTO);
        }

        return chamadoDTOs;
    }

    public Chamado findChamadoById(Long id) {
        Optional<Chamado> chamado = chamadoRepository.findById(id);
        return chamado.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Solicitação de chamado não encontrada"));
    }

    public void concluirChamado(Long id) {
        Chamado chamado = findChamadoById(id);
        chamado.setStatusChamados(StatusChamados.CONCLUIDO);
        chamado.setHorarioConclusao(LocalDateTime.now());
        chamado.setDataConclusao(LocalDate.now());
        chamadoRepository.save(chamado);
    }
}
