package org.acsousa.domain.enums;

public enum AcaoRodada {
    PEDIR ("Pedir"),
    PARAR ("Parar"),
    DOBRAR ("Dobrar"),
    DIVIDIR ("Dividir");

    private final String descricao;

    AcaoRodada(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
