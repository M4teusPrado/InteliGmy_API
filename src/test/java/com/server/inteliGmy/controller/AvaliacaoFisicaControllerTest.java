package com.server.inteliGmy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.server.inteliGmy.DTOs.AvaliacaoFisicaDTO;
import com.server.inteliGmy.service.AvaliacaoFisicaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
class AvaliacaoFisicaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AvaliacaoFisicaService avaliacaoFisicaService;

    @Test
    void testScheduleAvaliacaoFisicaForInstructor() throws Exception {
        // Arrange
        AvaliacaoFisicaDTO avaliacaoFisicaDTO = new AvaliacaoFisicaDTO();
        avaliacaoFisicaDTO.setUidInstrutor("1"); // Defina o ID do instrutor conforme necessário
        avaliacaoFisicaDTO.setUidAluno("2"); // Defina o ID do aluno conforme necessário

        // Act
        mockMvc.perform(post("/avaliacao/agendarAvaliacao")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(avaliacaoFisicaDTO)))
                .andExpect(status().isOk());

        // Assert
        verify(avaliacaoFisicaService, times(1)).agendarAvaliacaoParaInstrutor(avaliacaoFisicaDTO);
    }

    // Método auxiliar para converter objeto em JSON
    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}