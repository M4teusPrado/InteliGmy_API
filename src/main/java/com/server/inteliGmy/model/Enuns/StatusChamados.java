package com.server.inteliGmy.model.Enuns;

public enum StatusChamados {

    ABERTO(0L),
    CONCLUIDO(1L);

    private long id;

    StatusChamados(long idClass) {
        this.id = idClass;

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
