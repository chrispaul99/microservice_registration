import { Instructivo } from '../Instructivo/instructivo';
import { Cronograma } from '../Cronograma/cronograma';
import { Administrador } from '../Administrador/administrador';
import { Materia } from '../Materia/materia';
export class Periodo {
    idPeriod: number;
    start_date: Date;
    end_date: Date;
    status: boolean;
    subjects: Materia[];
    schedule: Cronograma;
    instructive: Instructivo = new Instructivo();
    administrator: Administrador = new Administrador();
}
