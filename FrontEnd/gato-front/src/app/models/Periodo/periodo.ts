import { Instructivo } from '../Instructivo/instructivo';
export class Periodo {
    id: number;
    fechaInicio: Date;
    fechaFin: Date;
    descripcion: string;
    status: boolean;
    cronograma: File;
    instructivo: Instructivo = new Instructivo();
}
