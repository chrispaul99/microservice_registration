import { Instructivo } from '../Instructivo/instructivo';
import { Cronograma } from '../Cronograma/cronograma';
export class Periodo {
    id: number;
    fechaInicio: Date;
    fechaFin: Date;
    descripcion: string;
    status: boolean;
    cronograma: Cronograma = new Cronograma();
    instructivo: Instructivo = new Instructivo();
}
