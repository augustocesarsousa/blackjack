package org.acsousa.domain.entities;

import org.acsousa.domain.enums.Naipe;

import java.util.*;

public class Baralho {

    private final List<Carta> cartas = new ArrayList<>();

    public Baralho () {
        this.criarBaralho();
        this.embaralhar();
    }

    private void criarBaralho() {
        cartas.addAll(naipeDeCopas());
        cartas.addAll(naipeDeEspadas());
        cartas.addAll(naipeDeOuros());
        cartas.addAll(naipeDePaus());
    }

    private List<Carta> naipeDeCopas() {
        List<Carta> copas = new ArrayList<>();

        copas.add(new Carta(Naipe.COPAS, "As", "A", 1));
        copas.add(new Carta(Naipe.COPAS, "Dois", "2", 2));
        copas.add(new Carta(Naipe.COPAS, "Três", "3", 3));
        copas.add(new Carta(Naipe.COPAS, "Quatro", "4", 4));
        copas.add(new Carta(Naipe.COPAS, "Cinco", "5", 5));
        copas.add(new Carta(Naipe.COPAS, "Seis", "6", 6));
        copas.add(new Carta(Naipe.COPAS, "Sete", "7", 7));
        copas.add(new Carta(Naipe.COPAS, "Oito", "8", 8));
        copas.add(new Carta(Naipe.COPAS, "Nove", "9", 9));
        copas.add(new Carta(Naipe.COPAS, "Dez", "10", 10));
        copas.add(new Carta(Naipe.COPAS, "Valete", "J", 10));
        copas.add(new Carta(Naipe.COPAS, "Dama", "Q", 10));
        copas.add(new Carta(Naipe.COPAS, "Rei", "K", 10));

        return copas;
    }

    private List<Carta> naipeDeEspadas() {
        List<Carta> espadas = new ArrayList<>();

        espadas.add(new Carta(Naipe.ESPADAS, "As", "A", 1));
        espadas.add(new Carta(Naipe.ESPADAS, "Dois", "2", 2));
        espadas.add(new Carta(Naipe.ESPADAS, "Três", "3", 3));
        espadas.add(new Carta(Naipe.ESPADAS, "Quatro", "4", 4));
        espadas.add(new Carta(Naipe.ESPADAS, "Cinco", "5", 5));
        espadas.add(new Carta(Naipe.ESPADAS, "Seis", "6", 6));
        espadas.add(new Carta(Naipe.ESPADAS, "Sete", "7", 7));
        espadas.add(new Carta(Naipe.ESPADAS, "Oito", "8", 8));
        espadas.add(new Carta(Naipe.ESPADAS, "Nove", "9", 9));
        espadas.add(new Carta(Naipe.ESPADAS, "Dez", "10", 10));
        espadas.add(new Carta(Naipe.ESPADAS, "Valete", "J", 10));
        espadas.add(new Carta(Naipe.ESPADAS, "Dama", "Q", 10));
        espadas.add(new Carta(Naipe.ESPADAS, "Rei", "K", 10));

        return espadas;
    }

    private List<Carta> naipeDeOuros() {
        List<Carta> ouros = new ArrayList<>();

        ouros.add(new Carta(Naipe.OUROS, "As", "A", 1));
        ouros.add(new Carta(Naipe.OUROS, "Dois", "2", 2));
        ouros.add(new Carta(Naipe.OUROS, "Três", "3", 3));
        ouros.add(new Carta(Naipe.OUROS, "Quatro", "4", 4));
        ouros.add(new Carta(Naipe.OUROS, "Cinco", "5", 5));
        ouros.add(new Carta(Naipe.OUROS, "Seis", "6", 6));
        ouros.add(new Carta(Naipe.OUROS, "Sete", "7", 7));
        ouros.add(new Carta(Naipe.OUROS, "Oito", "8", 8));
        ouros.add(new Carta(Naipe.OUROS, "Nove", "9", 9));
        ouros.add(new Carta(Naipe.OUROS, "Dez", "10", 10));
        ouros.add(new Carta(Naipe.OUROS, "Valete", "J", 10));
        ouros.add(new Carta(Naipe.OUROS, "Dama", "Q", 10));
        ouros.add(new Carta(Naipe.OUROS, "Rei", "K", 10));

        return ouros;
    }

    private List<Carta> naipeDePaus() {
        List<Carta> paus = new ArrayList<>();

        paus.add(new Carta(Naipe.PAUS, "As", "A", 1));
        paus.add(new Carta(Naipe.PAUS, "Dois", "2", 2));
        paus.add(new Carta(Naipe.PAUS, "Três", "3", 3));
        paus.add(new Carta(Naipe.PAUS, "Quatro", "4", 4));
        paus.add(new Carta(Naipe.PAUS, "Cinco", "5", 5));
        paus.add(new Carta(Naipe.PAUS, "Seis", "6", 6));
        paus.add(new Carta(Naipe.PAUS, "Sete", "7", 7));
        paus.add(new Carta(Naipe.PAUS, "Oito", "8", 8));
        paus.add(new Carta(Naipe.PAUS, "Nove", "9", 9));
        paus.add(new Carta(Naipe.PAUS, "Dez", "10", 10));
        paus.add(new Carta(Naipe.PAUS, "Valete", "J", 10));
        paus.add(new Carta(Naipe.PAUS, "Dama", "Q", 10));
        paus.add(new Carta(Naipe.PAUS, "Rei", "K", 10));

        return paus;
    }

    public void embaralhar() {
        Collections.shuffle(cartas);
    }

    public Carta pegarCarta() {
        return cartas.removeFirst();
    }

    public Integer qtdCartas() {
        return cartas.size();
    }
}
