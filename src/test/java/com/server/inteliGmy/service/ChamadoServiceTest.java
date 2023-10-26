package com.server.inteliGmy.service;

import com.server.inteliGmy.DTOs.FeedbackDTO;
import com.server.inteliGmy.DTOs.SolicitacaoChamadoDTO;
import com.server.inteliGmy.model.Aluno;
import com.server.inteliGmy.model.Chamado;
import com.server.inteliGmy.model.Feedback;
import com.server.inteliGmy.model.Instrutor;
import com.server.inteliGmy.repository.ChamadoRepository;
import com.server.inteliGmy.repository.FeedbackRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;


public class ChamadoServiceTest {

    private final ChamadoService chamadoService;

    @Mock
    private ChamadoRepository chamadoRepository;

    @Mock
    private FeedbackRepository feedbackRepository;

    @Mock
    private InstrutorService instrutorService;

    @Mock
    private AlunoService alunoService;

    public ChamadoServiceTest() {
        MockitoAnnotations.openMocks(this);
        chamadoService = new ChamadoService(chamadoRepository, feedbackRepository, instrutorService, alunoService);
    }

    @Test
    void testSolicitarChamado() {
        // Arrange
        SolicitacaoChamadoDTO chamadoDTO = new SolicitacaoChamadoDTO();
        chamadoDTO.setUidInstrutor("1"); // Defina o ID do instrutor conforme necessário
        chamadoDTO.setUidAluno("2"); // Defina o ID do aluno conforme necessário

        when(instrutorService.getInstrutorById("1")).thenReturn(new Instrutor());
        when(alunoService.getAlunoById("2")).thenReturn(new Aluno());

        // Act
        chamadoService.solicitarChamado(chamadoDTO);

        // Assert
        verify(chamadoRepository, times(1)).save(any(Chamado.class));
    }

    @Test
    void testRegistrarFeedback() {
        // Arrange
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setUidInstrutorAvaliado("1"); // Defina o ID do instrutor avaliado conforme necessário
        feedbackDTO.setUidAlunoAvaliador("2"); // Defina o ID do aluno avaliador conforme necessário

        when(instrutorService.getInstrutorById("1")).thenReturn(new Instrutor());
        when(alunoService.getAlunoById("2")).thenReturn(new Aluno());

        // Act
        chamadoService.registrarFeedback(feedbackDTO);

        // Assert
        verify(feedbackRepository, times(1)).save(any(Feedback.class));
    }
}
