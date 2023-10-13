package com.server.inteliGmy.model;

import com.server.inteliGmy.model.Enuns.Nivel;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Instrutor extends BaseUser {

    private String horario;
    private String senhaTemporaria;

    @Override
    public void setNivel(Nivel nivel) {
        super.setNivel(Nivel.INSTRUTOR);
    }
}
