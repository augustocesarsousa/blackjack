export interface Carta {
  naipe: 'COPAS' | 'OUROS' | 'ESPADAS' | 'PAUS';
  nome: string;
  simbulo: string;
  valor: number;
  aberta: boolean;
}
