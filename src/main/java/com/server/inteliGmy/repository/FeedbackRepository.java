package com.server.inteliGmy.repository;

import com.server.inteliGmy.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    @Query("SELECT AVG(f.classificacao) FROM Feedback f WHERE f.instrutorAvaliado.id = :idInstrutor")
    Double calcularMediaClassificacaoPorInstrutor(@Param("idInstrutor") Long idInstrutor);

}
