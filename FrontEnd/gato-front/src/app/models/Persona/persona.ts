import { Usuario } from '../Usuario/Usuario';
export class Persona {
    ID: string;
    nombres: string;
    apellidos: string;
    fechaNac: Date;
    cedula: string;
    telefono: string;
    user: Usuario = new Usuario();
}
export class Login{
    ID: string;
    password: string;
}
