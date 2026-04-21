package org.acsousa.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.acsousa.domain.enums.ResultadoPartida;

public class Partida {

    private Jogador jogador;
    private Dealer dealer;
    @JsonIgnore
    private Baralho baralho;
    private boolean emAndamento;
    private ResultadoPartida resultado;

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public Baralho getBaralho() {
        return baralho;
    }

    public void setBaralho(Baralho baralho) {
        this.baralho = baralho;
    }

    public boolean isEmAndamento() {
        return emAndamento;
    }

    public void setEmAndamento(boolean emAndamento) {
        this.emAndamento = emAndamento;
    }

    public ResultadoPartida getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoPartida resultado) {
        this.resultado = resultado;
    }
}
