import { Jogador } from './jogador.interface';
import { Dealer } from './dealer.interface';
import { ResultadoPartida } from '../types/resultado-partida.type';

export interface Partida {
  jogador: Jogador;
  dealer: Dealer;
  emAndamento: boolean;
  resultado?: ResultadoPartida;
}
