package com.server.inteliGmy.repository;

import com.server.inteliGmy.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AvaliacaoFisicaRepository extends JpaRepository<Avaliacao, Long> {

    List<Avaliacao> findByDataAvaliacao(LocalDate data);
}
