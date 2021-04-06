import { Administrador } from '../Administrador/administrador';

export class Instructivo {
    idInstructive: number;
    document: File;
    status: boolean;
    administrator: Administrador = new Administrador();
    }
