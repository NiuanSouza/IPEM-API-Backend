-- V3__setup_security.sql
-- Atualiza as senhas de 'senha123' para o Hash BCrypt correspondente (senha: 123456)
UPDATE usuarios
SET senha = '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.TVuHOnu'
WHERE num_registro IN (10001, 10002, 10003, 10004, 10005, 10006, 10007, 10008, 10009, 10010);