package com.server.inteliGmy.service;

import com.server.inteliGmy.DTOs.ExercicioDTO;
import com.server.inteliGmy.DTOs.ExercicioDTOResponse;
import com.server.inteliGmy.DTOs.TreinoDTO;
import com.server.inteliGmy.DTOs.TreinoDTOResponse;
import com.server.inteliGmy.model.Aluno;
import com.server.inteliGmy.model.Exercicio;
import com.server.inteliGmy.model.Instrutor;
import com.server.inteliGmy.model.Treino;
import com.server.inteliGmy.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class TreinoService {

    @Autowired
    private TreinoRepository treinoRepository;

    @Autowired
    private InstrutorService instrutorService;

    @Autowired
    private AlunoService alunoService;


    public void  criarTreino(TreinoDTO treinoDTO) {
        Treino treino = criarNovoTreino(treinoDTO);
        treinoRepository.save(treino);
    }

    private Treino criarNovoTreino(TreinoDTO dto) {
        Instrutor instrutor = instrutorService.getInstrutorById(dto.getUidInstrutor());
        Aluno aluno = alunoService.getAlunoById(dto.getUidAluno());

        Treino treino = new Treino();
        treino.setInstrutor(instrutor);
        treino.setAluno(aluno);
        treino.setNome(dto.getNomeTreino());
        treino.setObjetivo(dto.getObjetivo());
        treino.setDataInicio(dto.getDataInicio());
        treino.setDataFim(dto.getDataFim());

        if(dto.getExercicioList() != null ){
            for(Exercicio e : dto.getExercicioList() ) {
                e.setTreino(treino);
                treino.addExercicio(e);
            }
        }
        return treino;
    }

    public List<TreinoDTOResponse> getTreinoByAluno(String uidAluno) {
        List<Treino> treinos = treinoRepository.findTreinosByUidAluno(uidAluno);
        List<TreinoDTOResponse> dtos = new ArrayList<>();

        for (Treino treino : treinos) {
            TreinoDTOResponse dto = new TreinoDTOResponse();
            dto.setId(treino.getId());
            dto.setNomeTreino(treino.getNome());
            dtos.add(dto);
        }

        return dtos;
    }

    private Treino getTreinoById(Long id) {
        return treinoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Treino não encontrado"));
    }

    public void deleteTreino(Long id) {
        Treino treino = getTreinoById(id);
        treinoRepository.deleteById(treino.getId());
    }

    public List<ExercicioDTOResponse> getExerciciosByTreino(Long id) {
        List<Exercicio> exercicios = getTreinoById(id).getExercicioList();
        List<ExercicioDTOResponse> dtos = new ArrayList<>();

        for(Exercicio e : exercicios) {
            dtos.add(toExercicioDTOResponse(e));
        }

        return dtos;
    }


    public ExercicioDTOResponse toExercicioDTOResponse(Exercicio exercicio) {
        ExercicioDTOResponse dto = new ExercicioDTOResponse();
        dto.setId(exercicio.getId());
        dto.setNome(exercicio.getNome());
        dto.setRepeticoes(exercicio.getRepeticoes());
        dto.setSeries(exercicio.getSeries());
        dto.setPeso(exercicio.getPeso());
        return dto;
    }

    public void adicionarExercicio(Long id, ExercicioDTO dto) {
        Treino treino = getTreinoById(id);
        Exercicio exercicio = toExercicio(dto);

        exercicio.setTreino(treino);
        treino.addExercicio(exercicio);
        treinoRepository.save(treino);
    }

    public Exercicio toExercicio(ExercicioDTO dto) {
        Exercicio exercicio = new Exercicio();
        exercicio.setNome(dto.getNome());
        exercicio.setRepeticoes(dto.getRepeticoes());
        exercicio.setSeries(dto.getSeries());
        exercicio.setPeso(dto.getPeso());
        exercicio.setTipo(dto.getTipoExercicio());
        return exercicio;
    }
}
