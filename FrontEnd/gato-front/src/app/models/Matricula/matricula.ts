import { Estudiante } from '../Estudiante/estudiante';
import { Materia } from '../Materia/materia';
import { Periodo } from '../Periodo/periodo';
export class Matricula {
    id: number;
    estudiante: Estudiante;
    materias: Materia[];
    fecha: Date;
    tipo: string;
    periodo: Periodo;
    totalCreditos: number;
    pagoTotal: number;
    status: boolean;
}
