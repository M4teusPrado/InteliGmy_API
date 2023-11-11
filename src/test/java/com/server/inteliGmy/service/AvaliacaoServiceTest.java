package com.server.inteliGmy.service;

import com.server.inteliGmy.DTOs.avaliacao.AgendamentoAvaliacaoFisicaDTO;
import com.server.inteliGmy.model.Aluno;
import com.server.inteliGmy.model.Avaliacao;
import com.server.inteliGmy.model.Instrutor;
import com.server.inteliGmy.repository.AvaliacaoFisicaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class AvaliacaoServiceTest {

    private final AvaliacaoFisicaService avaliacaoFisicaService;

    @Mock
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Mock
    private InstrutorService instrutorService;

    @Mock
    private AlunoService alunoService;

    public AvaliacaoServiceTest() {
        MockitoAnnotations.openMocks(this);
        avaliacaoFisicaService = new AvaliacaoFisicaService(avaliacaoFisicaRepository, instrutorService, alunoService);
    }

    @Test
    void testAgendarAvaliacaoParaInstrutor() {
        // Arrange
        AgendamentoAvaliacaoFisicaDTO agendamentoAvaliacaoFisicaDTO = new AgendamentoAvaliacaoFisicaDTO();
        agendamentoAvaliacaoFisicaDTO.setUidInstrutor("1"); // Defina o ID do instrutor conforme necessário
        agendamentoAvaliacaoFisicaDTO.setUidAluno("2"); // Defina o ID do aluno conforme necessário

        when(instrutorService.getInstrutorById("1")).thenReturn(new Instrutor());
        when(alunoService.getAlunoById("2")).thenReturn(new Aluno());

        // Act
        avaliacaoFisicaService.agendarAvaliacaoParaInstrutor(agendamentoAvaliacaoFisicaDTO);

        // Assert
        verify(avaliacaoFisicaRepository, times(1)).save(any(Avaliacao.class));
    }
}
