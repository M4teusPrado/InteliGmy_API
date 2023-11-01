package com.server.inteliGmy.repository;

import com.server.inteliGmy.model.AvaliacaoFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisica, Long> {

    List<AvaliacaoFisica> findByDataAvaliacao(LocalDate data);
}
