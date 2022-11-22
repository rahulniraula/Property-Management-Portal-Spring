-- USERS

INSERT INTO Users (id, email, firstname, lastname, password)
VALUES (111, 'admin@miu.edu', 'Admin', 'Admin', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT INTO Users (id, email, firstname, lastname, password)
VALUES (112, 'testuser01@miu.edu', 'Test', 'User', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT INTO Users (id, email, firstname, lastname, password)
VALUES (113, 'mohammad.fuad@miu.edu', 'Mohammad', 'Fuad', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123

-- Role
INSERT INTO role (id, role)
VALUES (1, 'ADMIN');
INSERT INTO role (id, role)
VALUES (2, 'CUSTOMER');
INSERT INTO role (id, role)
VALUES (3, 'OWNER');
INSERT INTO role (id, role)
VALUES (4, 'VIEWER');

INSERT INTO users_roles (user_id, roles_id)
VALUES (111, 1);
INSERT INTO users_roles (user_id, roles_id)
VALUES (112, 2);
INSERT INTO users_roles (user_id, roles_id)
VALUES (113, 2);