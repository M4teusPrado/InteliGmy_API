package com.server.inteliGmy.repository;

import com.server.inteliGmy.model.Aluno;
import com.server.inteliGmy.model.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {

    @Query("SELECT i.gerente.alunos FROM Instrutor i WHERE i.uid = :uidInstrutor")
    List<Aluno> findAlunosByInstrutorId(@Param("uidInstrutor") String uidInstrutor);


    @Query(
            " SELECT a FROM Instrutor a " +
                    " WHERE a.uid = :uid"
    )
    Optional<Instrutor> findByUid(String uid);


}
