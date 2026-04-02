-- V3__corrigir_senhas_e_tipos.sql

-- Corrigir os tipos das colunas (Necessário para o Hibernate parar de dar erro)
ALTER TABLE abastecimentos
    MODIFY COLUMN preco_litro DOUBLE NOT NULL,
    MODIFY COLUMN valor_total DOUBLE NOT NULL;

-- Atualizar as senhas dos usuários já existentes para BCrypt
UPDATE usuarios SET senha = '$2a$10$8.U nVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.TVuHOnu'
WHERE num_registro IN (10001, 10002, 10003, 10004, 10005, 10006, 10007, 10008, 10009, 10010);