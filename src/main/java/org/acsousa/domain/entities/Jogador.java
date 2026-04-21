package org.acsousa.domain.entities;

import org.acsousa.domain.enums.AcaoRodada;

import java.util.ArrayList;
import java.util.List;

public class Jogador {

    private final String nome;
    private final List<Mao> maos = new ArrayList<>();
    private final List<AcaoRodada> acoesDisponiveis = new ArrayList<>();

    public Jogador() {
        this.nome = "James Bond";
        maos.add(new Mao());
    }

    public String getNome() {
        return nome;
    }

    public List<AcaoRodada> getAcoesDisponiveis() {
        return acoesDisponiveis;
    }

    public List<Mao> getMaos() {
        return maos;
    }

    public void adicionarCarta(Integer numeroDaMao, Carta carta) {
        if (this.maos.get(numeroDaMao) != null) {
            this.maos.get(numeroDaMao).adicionarCarta(carta);
        }
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

    public void atualizarAcoesDisponiveis(boolean partidaEmAndamento) {
        this.acoesDisponiveis.clear();

        if (!partidaEmAndamento) {
            return;
        }

        Mao mao = this.maos.get(0);
        int pontos = mao.getPontos();

        if (pontos < 21) {
            this.acoesDisponiveis.add(AcaoRodada.PEDIR);
            this.acoesDisponiveis.add(AcaoRodada.PARAR);
        }

//        if (mao.getCartas().size() == 2 && pontos < 21) {
//            this.acoesDisponiveis.add(AcaoRodada.DOBRAR);
//        }
//
//        if (mao.getCartas().size() == 2) {
//            Carta c1 = mao.getCartas().get(0);
//            Carta c2 = mao.getCartas().get(1);
//            if (Objects.equals(c1.getValor(), c2.getValor())) {
//                this.acoesDisponiveis.add(AcaoRodada.DIVIDIR);
//            }
//        }
    }
}
