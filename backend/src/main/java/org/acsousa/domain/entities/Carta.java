package org.acsousa.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.acsousa.domain.enums.Naipe;

public class Carta {

    private final Naipe naipe;
    private final String nome;
    private final String simbolo;
    private final Integer valor;
    private boolean aberta;

    public Carta(Naipe naipe, String nome, String simbolo, Integer valor) {
        this.naipe = naipe;
        this.nome = nome;
        this.simbolo = simbolo;
        this.valor = valor;
        this.aberta = true;
    }

    public Naipe getNaipe() {
        return naipe;
    }

    public String getNome() {
        return nome;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public Integer getValor() {
        return valor;
    }

    public boolean isAberta() {
        return this.aberta;
    }

    public void virarCarta(boolean opcao) {
        this.aberta = opcao;
    }

    @JsonProperty("valor")
    public Integer getValorExibicao() {
        return aberta ? valor : null;
    }

    @JsonProperty("nome")
    public String getNomeExibicao() {
        return aberta ? nome : "Oculta";
    }

    @JsonProperty("simbolo")
    public String getSimboloExibicao() {
        return aberta ? simbolo : "?";
    }

    @JsonProperty("naipe")
    public Naipe getNaipeExibicao() {
        return aberta ? naipe : null;
    }

    @Override
    public String toString() {
        return nome + " de " + naipe;
    }
}
