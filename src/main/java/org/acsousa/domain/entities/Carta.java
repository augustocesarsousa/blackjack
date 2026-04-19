package org.acsousa.domain.entities;

import org.acsousa.domain.enums.Naipe;

public class Carta {

    private final Naipe naipe;
    private final String nome;
    private final String simbulo;
    private final Integer valor;

    public Carta(Naipe naipe, String nome, String simbulo, Integer valor) {
        this.naipe = naipe;
        this.nome = nome;
        this.simbulo = simbulo;
        this.valor = valor;
    }

    public Naipe getNaipe() {
        return naipe;
    }

    public String getNome() {
        return nome;
    }

    public String getSimbulo() {
        return simbulo;
    }

    public Integer getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return nome + " de " + naipe;
    }
}
