import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Partida } from '../../shared/models/partida.interface';

@Injectable({
  providedIn: 'root',
})
export class PartidaService {
  private readonly http = inject(HttpClient);

  private readonly API_URL = 'http://localhost:8080/api/partida';

  novoJogo(): Observable<Partida> {
    return this.http.post<Partida>(`${this.API_URL}/novo-jogo`, {});
  }

  obterPartidaAtual(): Observable<Partida> {
    return this.http.get<Partida>(this.API_URL);
  }

  pedirCarta(): Observable<Partida> {
    return this.http.patch<Partida>(`${this.API_URL}/pedir-carta`, {});
  }

  parar(): Observable<Partida> {
    return this.http.patch<Partida>(`${this.API_URL}/parar`, {});
  }

  resetarPartida(): Observable<void> {
    return this.http.delete<void>(this.API_URL);
  }
}
