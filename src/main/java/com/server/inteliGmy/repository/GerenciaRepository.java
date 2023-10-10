package com.server.inteliGmy.repository;

import com.server.inteliGmy.model.Gerencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface GerenciaRepository extends JpaRepository<Gerencia, Long> {

    @Query(
            " SELECT a FROM Gerencia a " +
                    " WHERE a.uid = :uid"
    )
    Gerencia findByUid(String uid);
}
