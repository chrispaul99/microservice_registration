import { Instructivo } from '../Instructivo/instructivo';
import { Cronograma } from '../Cronograma/cronograma';
export class Periodo {
    idPeriod: number;
    start_date: Date;
    end_date: Date;
    status: boolean;
    cronograma: Cronograma = new Cronograma();
    instructivo: Instructivo = new Instructivo();
}
