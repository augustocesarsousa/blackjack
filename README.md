# Blackjack

Atividade de avaliação do projeto Hack the Favela no módulo de Java realizado pelo <a href="https://altbank.ai/" target="_blank">alt.bank</a>.

Este projeto consiste na recriação do famoso jogo BlackJack ou 21 em português.

## Objetivo do jogo

O objetivo do jogo é chegar mais próximo ou igual ao valor 21 com base na soma das cartas do jogador.

A somatória das cartas será feita conforme tabela abaixo:

| Carta | Valor no jogo|
|--|--|
| 2 a 10 | Vale o valor impresso na carta |
| Valete (J), Dama (Q), Rei (K) |Todas valem 10|
|Ás (A)|Pode valer 1 ou 11, dependendo do que for melhor para sua mão|

## Participantes do jogo

O jogo é composto de um dealer (jogador representando a casa) contra até cinco jogadores.

## Rodadas

- O jogo inicia com os jogadores fazendo suas apostas.
- O dealer entrega duas cartas abertas (viradas para cima) para cada jogador e duas cartas para ele mesmo, 
porém uma carta dele é fechada (virada para baixo). 
- Se as duas primeiras cartas do jogador somarem 21 pontos, exemplo: Ás e uma carta de valor 10 (10, J, Q ou K), 
o jogador tem um Blackjack e ganha automaticamente (1.5x o valor apostado), 
a menos que o dealer também tenha um.

## Opções de Jogo

Quando for a vez do jogador, ele deve decidir o que fazer com base na sua soma atual:

- Pedir (Hit): O jogador pede mais uma carta para aumentar seu total. O jogador pode pedir quantas quiser, mas se passar 
de 21, o jogador "estoura" (bust) e perde a aposta na hora.
- Parar (Stand): O jogador encerra sua jogada com o que tem e espera o resultado do dealer.
- Dobrar (Double Down): O jogador dobra sua aposta inicial e recebe apenas mais uma carta. É arriscado, mas lucrativo se 
o jogador tiver uma mão forte (como um 11).
- Dividir (Split): Se o jogador receber duas cartas iguais (ex: dois 8s), pode separá-las em duas mãos diferentes, 
fazendo uma nova aposta de mesmo valor na segunda mão.

## Regras do dealer

O dealer não decide como jogar, ele segue regras rígidas da casa:

- Ele deve pedir cartas até somar pelo menos 17.
- Se ele somar 17 ou mais, ele deve parar.

## O jogador ganha se

- Sua soma final for maior que a do dealer (sem passar de 21).
- O dealer estourar (passar de 21) e o jogador não.
- Em caso de empate o dealer é o vencedor.
