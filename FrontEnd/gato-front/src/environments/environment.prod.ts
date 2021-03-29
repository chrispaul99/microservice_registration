import { HttpHeaders } from '@angular/common/http';

export const environment = {
  production: true,
  httpOptions: {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Accept: 'application/json'
    })
  },
  url: '',
};
