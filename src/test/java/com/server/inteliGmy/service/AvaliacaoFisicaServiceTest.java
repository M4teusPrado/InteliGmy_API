package com.server.inteliGmy.service;

import com.server.inteliGmy.DTOs.AvaliacaoFisicaDTO;
import com.server.inteliGmy.model.Aluno;
import com.server.inteliGmy.model.AvaliacaoFisica;
import com.server.inteliGmy.model.Instrutor;
import com.server.inteliGmy.repository.AvaliacaoFisicaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class AvaliacaoFisicaServiceTest {

    private final AvaliacaoFisicaService avaliacaoFisicaService;

    @Mock
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Mock
    private InstrutorService instrutorService;

    @Mock
    private AlunoService alunoService;

    public AvaliacaoFisicaServiceTest() {
        MockitoAnnotations.openMocks(this);
        avaliacaoFisicaService = new AvaliacaoFisicaService(avaliacaoFisicaRepository, instrutorService, alunoService);
    }

    @Test
    void testAgendarAvaliacaoParaInstrutor() {
        // Arrange
        AvaliacaoFisicaDTO avaliacaoFisicaDTO = new AvaliacaoFisicaDTO();
        avaliacaoFisicaDTO.setUidInstrutor("1"); // Defina o ID do instrutor conforme necessário
        avaliacaoFisicaDTO.setUidAluno("2"); // Defina o ID do aluno conforme necessário

        when(instrutorService.getInstrutorById("1")).thenReturn(new Instrutor());
        when(alunoService.getAlunoById("2")).thenReturn(new Aluno());

        // Act
        avaliacaoFisicaService.agendarAvaliacaoParaInstrutor(avaliacaoFisicaDTO);

        // Assert
        verify(avaliacaoFisicaRepository, times(1)).save(any(AvaliacaoFisica.class));
    }
}
