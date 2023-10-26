package com.server.inteliGmy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.server.inteliGmy.model.Aluno;
import com.server.inteliGmy.model.Instrutor;
import com.server.inteliGmy.service.AlunoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class AlunoControllerTest {

    // Constantes
    private static final String ALUNO_ENDPOINT = "/aluno";
    private static final String ALUNO_ID = "1";

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private AlunoService alunoService;

    AlunoControllerTest() {
    }

    @Test
    void shouldReturnAlunoById() throws Exception {
        // Arrange
        Aluno aluno = new Aluno();
        aluno.setId(1L);

        when(alunoService.getAlunoById(ALUNO_ID)).thenReturn(aluno);

        // Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(ALUNO_ENDPOINT + "/" + ALUNO_ID))
                .andReturn();

        // Assert
        assertEquals(200, result.getResponse().getStatus());
        // Adicione mais asserções conforme necessário
    }

    @Test
    void shouldUpdateAluno() throws Exception {
        // Arrange
        Aluno aluno = new Aluno();
        aluno.setId(1L);

        // Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put(ALUNO_ENDPOINT + "/" + ALUNO_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(aluno)))
                .andReturn();

        // Assert
        assertEquals(204, result.getResponse().getStatus());
    }

    @Test
    void shouldReturnInstrutoresByAlunoId() throws Exception {
        // Arrange
        List<Instrutor> instrutores = new ArrayList<>(); // Adicione os instrutores conforme necessário

        when(alunoService.getInstrutoressByAlunoId(ALUNO_ID)).thenReturn(instrutores);

        // Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(ALUNO_ENDPOINT + "/" + ALUNO_ID + "/instrutores"))
                .andReturn();

        // Assert
        assertEquals(200, result.getResponse().getStatus());
        // Adicione mais asserções conforme necessário
    }
}