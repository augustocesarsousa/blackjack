package org.acsousa.domain.entities;

import org.acsousa.domain.enums.AcaoRodada;

import java.util.ArrayList;
import java.util.List;

public class Jogador {

    private final String nome;
    private Integer fichas;
    private final Integer aposta;
    private final List<Mao> maos = new ArrayList<>();
    private final List<AcaoRodada> acoesDiponiveis = new ArrayList<>();

    public Jogador(String nome, Integer aposta) {
        this.nome = nome;
        this.fichas = 1000;
        if(aposta > this.fichas) {
            this.aposta = this.fichas;
        } else {
            this.aposta = aposta;
        }
        maos.add(new Mao());
    }

    public String getNome() {
        return nome;
    }

    public Integer getAposta() {
        return aposta;
    }

    public Integer getFichas() {
        return fichas;
    }

    public List<AcaoRodada> getAcoesDiponiveis() {
        return acoesDiponiveis;
    }

    public List<Mao> getMaos() {
        return maos;
    }

    public void adicionarCarta(Integer numeroDaMao, Carta carta) {
        if (this.maos.get(numeroDaMao) != null) {
            this.maos.get(numeroDaMao).adicionarCarta(carta);
        }
    }

    public void removerFichas(Integer quantidade) {
        if (this.fichas < quantidade) throw new RuntimeException("Jogador não possui fichas suficiente");
        this.fichas -= quantidade;
    }

    public void dividirMao() {
        if(maos.getFirst().getCartas().size() == 2) {
            String nomePrimeiraCarta = maos.getFirst().getCartas().getFirst().getNome();
            String nomeSegundaCarta = maos.getFirst().getCartas().get(1).getNome();

            if(nomePrimeiraCarta.equals(nomeSegundaCarta)) {
                this.maos.add(new Mao());
                Carta carta = maos.getFirst().getCartas().remove(1);
                this.maos.get(1).adicionarCarta(carta);
            }
        }
    }
}
