package com.server.inteliGmy.model.Enuns;

public enum TipoExercicio {

    PEITO(0L, "Peito"),
    PERNA(1L, "Perna"),
    COSTA(2L, "Costa"),
    OMBRO(3L, "Ombro"),
    BRACO(4L, "Braço"),
    ABDOMEN(5L, "Abdômen"),
    BICEPS(6L, "Bíceps"),
    TRICEPS(7L, "Tríceps"),
    ANTEBRACO(8L, "Antebraço"),
    CARDIO(9L, "Cardio"),
    OUTRO(10L, "Outro");

    private long id;
    private String descricao;

    TipoExercicio(long idClass, String descricao) {
        this.id = idClass;
        this.descricao = descricao;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
