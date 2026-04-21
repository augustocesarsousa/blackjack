import { HttpInterceptorFn, HttpErrorResponse } from '@angular/common/http';
import { catchError, throwError } from 'rxjs';

export const errorInterceptor: HttpInterceptorFn = (req, next) => {
  return next(req).pipe(
    catchError((error: HttpErrorResponse) => {
      let mensagemAmigavel = 'Houve um problema na mesa de jogo.';

      if (error.error && typeof error.error === 'object' && 'message' in error.error) {
        mensagemAmigavel = error.error.message;
      } else if (typeof error.error === 'string') {
        mensagemAmigavel = error.error;
      }

      alert(mensagemAmigavel);

      return throwError(() => new Error(mensagemAmigavel));
    }),
  );
};
