package com.server.inteliGmy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.server.inteliGmy.model.Gerencia;
import com.server.inteliGmy.model.Instrutor;
import com.server.inteliGmy.service.GerenciaService;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GerenciaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GerenciaService gerenciaService;

    @Autowired
    private ObjectMapper objectMapper;

    public GerenciaControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetGerenciaById() throws Exception {
        Gerencia gerencia = new Gerencia();
        gerencia.setId(1L);
        gerencia.setNomeAcademia("Nome da Academia");
        gerencia.setCnpj("123456789");
        gerencia.setSenha("senha");

        when(gerenciaService.getGerenciaById(anyString())).thenReturn(gerencia);

        mockMvc.perform(get("/owner/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(gerencia)));
    }

    @Test
    void testGetGerentes() throws Exception {
        Gerencia gerencia1 = new Gerencia();
        gerencia1.setId(1L);
        gerencia1.setNomeAcademia("Academia 1");
        gerencia1.setCnpj("123456789");
        gerencia1.setSenha("senha1");

        Gerencia gerencia2 = new Gerencia();
        gerencia2.setId(2L);
        gerencia2.setNomeAcademia("Academia 2");
        gerencia2.setCnpj("987654321");
        gerencia2.setSenha("senha2");

        when(gerenciaService.getGerentes()).thenReturn(List.of(gerencia1, gerencia2));

        mockMvc.perform(get("/owner"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(List.of(gerencia1, gerencia2))));
    }

    @Test
    void testUpdateGerencia() throws Exception {
        mockMvc.perform(put("/owner/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isNoContent());
    }

    @Test
    void testInsertGerencia() throws Exception {
        Gerencia gerencia = new Gerencia();
        gerencia.setNomeAcademia("Nova Academia");
        gerencia.setCnpj("987654321");
        gerencia.setSenha("novasenha");

        when(gerenciaService.saveGerencia(any(Gerencia.class))).thenReturn(gerencia);

        mockMvc.perform(post("/owner")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(gerencia)))
                .andExpect(status().isCreated());
    }

    @Test
    void testInsertInstrutor() throws Exception {
        Instrutor instrutor = new Instrutor();
        instrutor.setId(1L);
        instrutor.setNome("Instrutor Teste");

        when(gerenciaService.insertInstrutor(anyString(), any(Instrutor.class))).thenReturn(instrutor);

        MvcResult result = mockMvc.perform(post("/owner/1/instrutor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(instrutor)))
                .andExpect(status().isCreated())
                .andReturn();

        String locationHeader = result.getResponse().getHeader("Location");
        assertNotNull(locationHeader);
        assertEquals(201, result.getResponse().getStatus());
    }

    @Test
    void testGetInstrutoresByGerente() throws Exception {
        Instrutor instrutor1 = new Instrutor();
        instrutor1.setId(1L);
        instrutor1.setNome("Instrutor 1");

        Instrutor instrutor2 = new Instrutor();
        instrutor2.setId(2L);
        instrutor2.setNome("Instrutor 2");

        when(gerenciaService.getInstrutores(anyString())).thenReturn(List.of(instrutor1, instrutor2));

        mockMvc.perform(get("/owner/1/instrutores"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(List.of(instrutor1, instrutor2))));
    }

    @Test
    void testAssociateAlunoWithGerencia() throws Exception {
        mockMvc.perform(put("/owner/1/alunos/1"))
                .andExpect(status().isNoContent());
    }
}
