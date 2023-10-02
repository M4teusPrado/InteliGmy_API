package com.server.inteliGmy.repository;

import com.server.inteliGmy.model.Gerencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerenciaRepository extends JpaRepository<Gerencia, Long> {
}
