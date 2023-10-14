package com.server.inteliGmy.repository;

import com.server.inteliGmy.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    @Query(
            " SELECT a FROM Aluno a " +
                    " WHERE a.uid = :uid"
    )
    Optional<Aluno> findByUid(String uid);

}
