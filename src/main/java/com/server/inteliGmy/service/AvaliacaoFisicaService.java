package com.server.inteliGmy.service;

import com.server.inteliGmy.DTOs.avaliacao.AgendamentoAvaliacaoFisicaDTO;
import com.server.inteliGmy.DTOs.avaliacao.AvaliacaoDTO;
import com.server.inteliGmy.DTOs.avaliacao.AvaliacaoFisicaResponseDTO;
import com.server.inteliGmy.DTOs.avaliacao.BaseAvaliacaoDTO;
import com.server.inteliGmy.model.Aluno;
import com.server.inteliGmy.model.Avaliacao;
import com.server.inteliGmy.model.Instrutor;
import com.server.inteliGmy.repository.AvaliacaoFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public void agendarAvaliacaoParaInstrutor(AgendamentoAvaliacaoFisicaDTO dto) {
        Avaliacao avaliacao = criarNovaAvaliacaoFisica(dto);
        salvarAvaliacaoFisica(avaliacao);
    }

    private Avaliacao criarNovaAvaliacaoFisica(BaseAvaliacaoDTO dto) {
        Instrutor instrutor = instrutorService.getInstrutorById(dto.getUidInstrutor());
        Aluno aluno = alunoService.getAlunoById(dto.getUidAluno());

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setInstrutor(instrutor);
        avaliacao.setAluno(aluno);
        avaliacao.setDataAvaliacao(dto.getDataAvaliacao());
        avaliacao.setHorarioAvaliacao(dto.getHorarioAvaliacao());
        return avaliacao;
    }

    public void salvarAvaliacaoFisica(Avaliacao avaliacao) {
        avaliacaoFisicaRepository.save(avaliacao);
    }

    public List<AvaliacaoFisicaResponseDTO> buscarAvaliacoesPorData(LocalDate data) {
        List<Avaliacao> avaliacoes = avaliacaoFisicaRepository.findByDataAvaliacao(data);
        return mapToResponseDTO(avaliacoes);
    }

    public void processarAvaliacaoFisica(AvaliacaoDTO dto) {
        Avaliacao avaliacao = (dto.getIdAvaliacao() == null) ?
                criarNovaAvaliacaoFisica(dto) :
                avaliacaoFisicaRepository.findById(dto.getIdAvaliacao()).get();

        avaliacao.setDataAvaliacao(LocalDate.now());
        avaliacao.setHorarioAvaliacao(LocalTime.now());
        avaliacao.setAvaliacaoFisica(dto.getAvaliacaoFisica());

        salvarAvaliacaoFisica(avaliacao);
    }

    public List<AvaliacaoFisicaResponseDTO> buscarAvaliacaoByAluno(String uidAluno) {
        List<Avaliacao> avaliacaos = avaliacaoFisicaRepository.buscarAvaliacaoByAluno(uidAluno);
        return mapToResponseDTO(avaliacaos);
    }

    public List<AvaliacaoFisicaResponseDTO> mapToResponseDTO(List<Avaliacao> avaliacoes) {
        return avaliacoes.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private AvaliacaoFisicaResponseDTO mapToDTO(Avaliacao avaliacao) {
        AvaliacaoFisicaResponseDTO dto = new AvaliacaoFisicaResponseDTO();
        dto.setId(avaliacao.getId());
        dto.setInstrutorId(avaliacao.getInstrutor().getId());
        dto.setAluno(avaliacao.getAluno());
        dto.setDataAvaliacao(avaliacao.getDataAvaliacao());
        dto.setHorarioAvaliacao(avaliacao.getHorarioAvaliacao());
        dto.setAvaliacaoFisica(avaliacao.getAvaliacaoFisica());
        return dto;
    }

    public AvaliacaoFisicaResponseDTO buscarAvaliacaoById(Long id) {
        return mapToDTO(avaliacaoFisicaRepository.findById(id).get());
    }
}
