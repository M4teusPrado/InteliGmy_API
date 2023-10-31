package com.server.inteliGmy.repository;

import com.server.inteliGmy.model.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Long> {


    @Query("SELECT c FROM Chamado c WHERE c.instrutor.uid = :uid and c.statusChamados = 0")
    List<Chamado> findChamadosAbertosByInstrutorUid(@Param("uid") String uid);

}
