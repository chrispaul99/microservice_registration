import { Usuario } from '../Usuario/Usuario';
export class Estudiante {
    id: number;
    assigned_career: string;
    registration_line: boolean;
    status: boolean;
    firstName: string;
    lastName: string;
    birth: Date;
    numberCardId: string;
    phone: string;
    placeofBirth: string;
    sex: string;
    user: Usuario = new Usuario();
}
