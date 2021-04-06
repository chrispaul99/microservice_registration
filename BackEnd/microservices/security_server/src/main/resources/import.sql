INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO users(email,password,username) VALUES('test@test.com','$2a$10$t9LLhLzaEMe2IBrn.PKOz.tcfC3T2q1LZTBld4eiT62.uAvXyZs4K','espe2121');

INSERT INTO user_roles(user_id,role_id) VALUES(1,1);




