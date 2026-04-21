package org.acsousa.domain.enums;

public enum Naipe {
    COPAS ("Copas"),
    ESPADAS ("Espadas"),
    OUROS ("Ouros"),
    PAUS ("Paus");

    private final String descricao;

    Naipe(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
