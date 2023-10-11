package com.server.inteliGmy.service;

import com.server.inteliGmy.model.Instrutor;
import com.server.inteliGmy.repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrutorService {

    @Autowired
    private InstrutorRepository instrutorRepository;

    public List<Instrutor> getInstrutores() {
        return instrutorRepository.findAll();
    }
}
