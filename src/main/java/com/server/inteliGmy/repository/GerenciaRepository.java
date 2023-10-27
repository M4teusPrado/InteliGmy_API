package com.server.inteliGmy.repository;

import com.server.inteliGmy.model.Gerencia;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface GerenciaRepository extends JpaRepository<Gerencia, Long> {

    @Query(
            " SELECT a FROM Gerencia a " +
                    " WHERE a.uid = :uid"
    )
    Optional<Gerencia> findByUid(String uid);

    @Query(value =
            "WITH RegistrosLog AS (" +
                    "SELECT " +
                        "EXTRACT(HOUR FROM lu.HORARIO_LOGIN) as horario, " +
                        "lu.DATA_LOGIN as dia, " +
                        "COUNT(*) as totalLogins " +
                    "FROM " +
                        "LOG_USUARIO lu " +
                            "INNER JOIN BASE_USER bu ON lu.BASE_USER_ID = bu.id and bu.nivel = 2 " +
                            "INNER JOIN ALUNO a ON a.id = bu.id and a.GERENCIA_ID = :idGerencia " +
                    "GROUP BY " +
                        "EXTRACT(HOUR FROM lu.HORARIO_LOGIN), lu.DATA_LOGIN " +
                    ") " +

                    "SELECT " +
                        "horario, " +
                        "AVG(totalLogins) as mediaLogins " +
                    "FROM " +
                        "RegistrosLog " +
                    "GROUP " +
                        "BY horario",
            nativeQuery = true)
    List<Tuple> contarUsuariosLogadosPorHorario(Long idGerencia);
}
