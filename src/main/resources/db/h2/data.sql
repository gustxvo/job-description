INSERT INTO tb_admins (user_id, password, role, locked, enabled) 
VALUES (0, '$2a$12$fNdROYExOI36XBXKYcRV8.pdk/7.RN2zB6WtqC31V9iIUP8rDgrNG', 'ADMIN', false, true);

INSERT INTO tb_departments (name_en, name_pt_br, acronym) 
VALUES 
('Human Resources', 'Recursos Humanos', 'RH'),
('Finances', 'Financeiro', 'FIN'),
('Marketing', 'Marketing', 'MKT'),
('Information Technology', 'Tecnologia da Informação', 'TI');

INSERT INTO tb_employees (user_id, password, role, locked, enabled, name, rg, cpf, phone, position, department, email, phone_ext, salary, status, admission_date, termination_date, 
                          address_street, address_number, address_complement, address_city, address_district, address_zip_code)
VALUES 
(1, '$2a$12$fNdROYExOI36XBXKYcRV8.pdk/7.RN2zB6WtqC31V9iIUP8rDgrNG', 'EMPLOYEE', false, true, 'Fernanda Souza', '987654321', '98765432100', '11976543210', 'Gerente Financeiro', 'Financeiro', 'fernanda@email.com', '5678', 7800.00, 0, '2021-07-22', NULL,
 'Av. Paulista', '2000', 'Sala 12', 'São Paulo', 'Bela Vista', '01310000'),

(2, '$2a$12$fNdROYExOI36XBXKYcRV8.pdk/7.RN2zB6WtqC31V9iIUP8rDgrNG', 'EMPLOYEE', false, true, 'José Oliveira', '112233445', '11122233344', '11965432109', 'Engenheiro de Software', 'Engenharia', 'jose@email.com', '4668', 7200.00, 2, '2020-05-10', '2024-07-31',
 'Rua dos Pinheiros', '88', 'Casa', 'São Paulo', 'Pinheiros', '05422001'),

(3, '$2a$12$fNdROYExOI36XBXKYcRV8.pdk/7.RN2zB6WtqC31V9iIUP8rDgrNG', 'EMPLOYEE', false, true, 'Mariana Almeida', '556667778', '55566677788', '11954321098', 'Coordenadora de RH', 'Recursos Humanos', 'mariana@email.com', '1414', 6000.00, 1, '2019-11-03', NULL,
 'Rua Augusta', '500', 'Bloco B', 'São Paulo', 'Consolação', '01222000'),

(4, '$2a$12$fNdROYExOI36XBXKYcRV8.pdk/7.RN2zB6WtqC31V9iIUP8rDgrNG', 'EMPLOYEE', false, true, 'Ricardo Santos', '445556667', '44455566677', '11943210987', 'Analista de Marketing', 'Marketing', 'ricardo@email.com', '9876', 4900.00, 2, '2023-01-12', '2025-05-13',
 'Av. Rebouças', '1234', 'Loja 3', 'São Paulo', 'Jardins', '01402000'),

(5, '$2a$12$fNdROYExOI36XBXKYcRV8.pdk/7.RN2zB6WtqC31V9iIUP8rDgrNG', 'EMPLOYEE', false, true, 'Carlos Silva', '123456789', '12345678900', '11987654321', 'Analista de Sistemas', 'TI', 'carlos@email.com', '1234', 5500.00, 0, '2022-03-15', NULL,
 'Rua das Flores', '123', 'Apto 45', 'São Paulo', 'Centro', '01010000');

UPDATE tb_departments SET position_holder_id = 3 WHERE department_id = 1; 
UPDATE tb_departments SET position_holder_id = 1 WHERE department_id = 2; 
UPDATE tb_departments SET position_holder_id = 4 WHERE department_id = 3; 
UPDATE tb_departments SET position_holder_id = 5 WHERE department_id = 4; 
