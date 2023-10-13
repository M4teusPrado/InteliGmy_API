package com.server.inteliGmy.model.Enuns;

public enum Nivel {

    GERENTE(0L),
    INSTRUTOR(1L),
    ALUNO(2L);

    private long id;

    Nivel(long idClass) {
        this.id = idClass;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
