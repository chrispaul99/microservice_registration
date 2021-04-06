import { Instructivo } from '../Instructivo/instructivo';
import { Cronograma } from '../Cronograma/cronograma';
import { Administrador } from '../Administrador/administrador';
export class Periodo {
    idPeriod: number;
    start_date: Date;
    end_date: Date;
    status: boolean;
    schedule: Cronograma = new Cronograma();
    instructive: Instructivo = new Instructivo();
    administrator: Administrador = new Administrador();
}
