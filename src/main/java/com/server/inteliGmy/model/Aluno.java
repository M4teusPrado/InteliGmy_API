package com.server.inteliGmy.model;

import com.server.inteliGmy.model.Enuns.Nivel;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Aluno extends BaseUser {

    @Override
    public void setNivel(Nivel nivel) {
        super.setNivel(Nivel.ALUNO);
    }
}
