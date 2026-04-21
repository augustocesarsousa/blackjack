import { Mao } from './mao.interface';
import { AcaoRodada } from '../types/acao-rodada.type';

export interface Jogador {
  nome: string;
  maos: Mao[];
  acoesDisponiveis: AcaoRodada[];
}
