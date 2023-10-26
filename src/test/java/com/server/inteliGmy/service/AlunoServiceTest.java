package com.server.inteliGmy.service;

import com.server.inteliGmy.model.Aluno;
import com.server.inteliGmy.model.Gerencia;
import com.server.inteliGmy.model.Instrutor;
import com.server.inteliGmy.repository.AlunoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest
class AlunoServiceTest {

    private AlunoService alunoService;

    @Mock
    private AlunoRepository alunoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        alunoService = new AlunoService(alunoRepository);
    }

    @Test
    void testCreateAluno() {
        // Arrange
        Aluno aluno = new Aluno();
        when(alunoRepository.save(aluno)).thenReturn(aluno);

        // Act
        Aluno result = alunoService.createAluno(aluno);

        // Assert
        assertNotNull(result);
        assertEquals(aluno, result);
    }

    @Test
    void testGetAlunoById() {
        // Arrange
        String uid = "1";
        Aluno aluno = new Aluno();
        when(alunoRepository.findByUid(uid)).thenReturn(Optional.of(aluno));

        // Act
        Aluno result = alunoService.getAlunoById(uid);

        // Assert
        assertNotNull(result);
        assertEquals(aluno, result);
    }

    @Test
    void testGetAlunoById_ThrowException() {
        // Arrange
        String uid = "2";
        when(alunoRepository.findByUid(uid)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResponseStatusException.class, () -> alunoService.getAlunoById(uid));
    }

    @Test
    void testUpdateAluno() {
        // Arrange
        String uid = "1";
        Aluno alunoDTO = new Aluno();
        alunoDTO.setNome("Novo Nome");
        alunoDTO.setEmail("novoemail@example.com");
        Aluno aluno = new Aluno();
        when(alunoRepository.findByUid(uid)).thenReturn(Optional.of(aluno));
        when(alunoRepository.save(aluno)).thenReturn(aluno);

        // Act
        alunoService.updateAluno(uid, alunoDTO);

        // Assert
        assertEquals("Novo Nome", aluno.getNome());
        assertEquals("novoemail@example.com", aluno.getEmail());
    }

    @Test
    void testGetInstrutoresByAlunoId() {
        // Arrange
        String uidAluno = "1";
        Aluno aluno = new Aluno();
        Gerencia gerencia = new Gerencia();
        Instrutor instrutor = new Instrutor();
        List<Instrutor> instrutores = new ArrayList<>();
        instrutores.add(instrutor);
        gerencia.setInstrutores(instrutores);
        aluno.setGerente(gerencia);
        when(alunoRepository.findByUid(uidAluno)).thenReturn(Optional.of(aluno));

        // Act
        List<Instrutor> result = alunoService.getInstrutoressByAlunoId(uidAluno);

        // Assert
        assertNotNull(result);
        assertEquals(instrutores, result);
    }
}