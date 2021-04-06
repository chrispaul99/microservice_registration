export class Usuario{
    id: number;
    email: string;
    username: string;
    password: string;
}

export class Roles{
    id: number;
    name: string;
}

export class User_Roles{
    user_id: number;
    role_id: number;
}

export class Login{
    username: string;
    password: string;
}
