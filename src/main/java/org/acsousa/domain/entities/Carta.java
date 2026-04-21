package org.acsousa.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.acsousa.domain.enums.Naipe;

public class Carta {

    private final Naipe naipe;
    private final String nome;
    private final String simbulo;
    private final Integer valor;
    private boolean aberta;

    public Carta(Naipe naipe, String nome, String simbulo, Integer valor) {
        this.naipe = naipe;
        this.nome = nome;
        this.simbulo = simbulo;
        this.valor = valor;
        this.aberta = true;
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

    @JsonProperty("simbulo")
    public String getSimbuloExibicao() {
        return aberta ? simbulo : "?";
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
