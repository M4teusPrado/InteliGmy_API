package com.server.inteliGmy.service;

import com.server.inteliGmy.DTOs.AvaliacaoFisicaDTO;
import com.server.inteliGmy.model.AvaliacaoFisica;
import com.server.inteliGmy.model.Aluno;
import com.server.inteliGmy.model.Instrutor;
import com.server.inteliGmy.repository.AvaliacaoFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoFisicaService {

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Autowired
    private InstrutorService instrutorService;

    @Autowired
    private AlunoService alunoService;

    public AvaliacaoFisicaService(AvaliacaoFisicaRepository avaliacaoFisicaRepository, InstrutorService instrutorService, AlunoService alunoService) {
        this.avaliacaoFisicaRepository = avaliacaoFisicaRepository;
        this.instrutorService = instrutorService;
        this.alunoService = alunoService;
    }

    public void agendarAvaliacaoParaInstrutor(AvaliacaoFisicaDTO dto) {
        AvaliacaoFisica avaliacaoFisica = criarNovaAvaliacaoFisica(dto);
        salvarAvaliacaoFisica(avaliacaoFisica);
    }

    private AvaliacaoFisica criarNovaAvaliacaoFisica(AvaliacaoFisicaDTO dto) {
        Instrutor instrutor = instrutorService.getInstrutorById(dto.getUidInstrutor());
        Aluno aluno =  alunoService.getAlunoById(dto.getUidAluno());

        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        avaliacaoFisica.setInstrutor(instrutor);
        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setDataAvaliacao(dto.getDataAvaliacao());
        avaliacaoFisica.setHorarioAvaliacao(dto.getHorarioAvaliacao());
        return avaliacaoFisica;
    }

    public void salvarAvaliacaoFisica(AvaliacaoFisica avaliacao) {
        avaliacaoFisicaRepository.save(avaliacao);
    }
}
