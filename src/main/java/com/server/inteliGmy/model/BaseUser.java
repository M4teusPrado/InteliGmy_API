package com.server.inteliGmy.model;

import com.server.inteliGmy.model.Enuns.Nivel;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public abstract class BaseUser {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String uid;
    private String nome;
    private String email;


    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Nivel nivel = Nivel.INSTRUTOR;
}
