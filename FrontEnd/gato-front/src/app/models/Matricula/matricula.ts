import { Materia } from '../Materia/materia';
import { Periodo } from '../Periodo/periodo';
export class Matricula {
    idRegistration: number;
    subject: Materia;
    date: Date;
    type: string;
    period: Periodo;
    paytotal: number;
    status: boolean;
}
