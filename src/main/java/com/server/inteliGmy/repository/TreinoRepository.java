package com.server.inteliGmy.repository;


import com.server.inteliGmy.model.Treino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreinoRepository extends JpaRepository<Treino, Long> {

    @Query("SELECT t FROM Treino t WHERE t.aluno.uid = :uidAluno")
    List<Treino> findTreinosByUidAluno(@Param("uidAluno") String uidAluno);
}
