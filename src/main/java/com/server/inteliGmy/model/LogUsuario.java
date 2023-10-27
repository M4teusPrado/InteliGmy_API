package com.server.inteliGmy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class LogUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private BaseUser baseUser;

    private LocalDate dataLogin;
    private LocalDateTime horarioLogin;

    public LogUsuario(BaseUser baseUser) {
        this.baseUser = baseUser;
        this.dataLogin = LocalDate.now();
        this.horarioLogin = LocalDateTime.now();
    }
}
