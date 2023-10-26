package com.server.inteliGmy.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.server.inteliGmy.DTOs.FeedbackDTO;
import com.server.inteliGmy.DTOs.SolicitacaoChamadoDTO;
import com.server.inteliGmy.service.ChamadoService;
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
class ChamadoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ChamadoService chamadoService;

    @Test
    void testSolicitarChamado() throws Exception {
        // Arrange
        SolicitacaoChamadoDTO solicitacaoChamadoDTO = new SolicitacaoChamadoDTO();
        // Defina os atributos de solicitacaoChamadoDTO conforme necessário

        // Act
        mockMvc.perform(post("/chamados/solicitar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(solicitacaoChamadoDTO)))
                .andExpect(status().isOk());

        // Assert
        verify(chamadoService, times(1)).solicitarChamado(solicitacaoChamadoDTO);
    }

    @Test
    void testRegistrarFeedback() throws Exception {
        // Arrange
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        // Defina os atributos de feedbackDTO conforme necessário

        // Act
        mockMvc.perform(post("/chamados/registrarFeedback")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(feedbackDTO)))
                .andExpect(status().isOk());

        // Assert
        verify(chamadoService, times(1)).registrarFeedback(feedbackDTO);
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
