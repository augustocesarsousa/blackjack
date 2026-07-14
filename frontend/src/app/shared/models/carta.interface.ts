export interface Carta {
  naipe: 'COPAS' | 'OUROS' | 'ESPADAS' | 'PAUS';
  nome: string;
  simbolo: string;
  valor: number;
  aberta: boolean;
}
