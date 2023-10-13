package com.server.inteliGmy.model;


import com.server.inteliGmy.model.Enuns.Nivel;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Data
@Entity
public class Gerencia extends BaseUser {

    private String nomeAcademia;
    private String cnpj;
    private String senha;

    @Override
    public void setNivel(Nivel nivel) {
        super.setNivel(Nivel.GERENTE);
    }

    @OneToMany
    private List<Instrutor> instrutores;

    public void addInstrutor(Instrutor instrutor) {
        this.instrutores.add(instrutor);
    }
}
