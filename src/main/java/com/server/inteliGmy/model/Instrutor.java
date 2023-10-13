package com.server.inteliGmy.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Instrutor extends BaseUser {

    private String horario;
    private String senhaTemporaria;


}
