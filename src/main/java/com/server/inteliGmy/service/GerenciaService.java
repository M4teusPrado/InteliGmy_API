package com.server.inteliGmy.service;

import com.server.inteliGmy.model.Gerencia;
import com.server.inteliGmy.repository.GerenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GerenciaService {

    @Autowired
    private GerenciaRepository gerenciaRepository;

    public Gerencia getGerencia(Long id) {
        try {
            return gerenciaRepository.findById(id).get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Administradior não encontrado");
        }
    }

    public Gerencia updateEvent(Long id, Gerencia adminDTO) {
        Gerencia doador = getGerencia(id);

        if(adminDTO.getNome() != null) doador.setNome(adminDTO.getNome());


        return gerenciaRepository.save(doador);
    }
}
