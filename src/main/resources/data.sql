-- INSERIR DADOS NA TABELA BASE_USER PARA A GERENCIA
INSERT INTO BASE_USER (UID, NOME, EMAIL, NIVEL)
VALUES
  ('c7PtkoKRVpfUWcRVPgigIy3IV262', 'Mateus Prado', 'mateus.silvaprado@gmail.com', 0),
  ('ArswkgZfI3gl1c6QNeJRbUioBj12', 'José Silva', 'jose.silva@gmail.com', 0),
  ('c7PtkoKRVpfUWcRVPgigIy3IV264', 'Maria Oliveira', 'maria.oliveira@example.com', 0),
  ('c7PtkoKRVpfUWcRVPgigIy3IV265', 'Carlos Santos', 'carlos.santos@example.com', 0),
  ('c7PtkoKRVpfUWcRVPgigIy3IV266', 'Ana Pereira', 'ana.pereira@example.com', 0);

-- INSERIR DADOS NA TABELA GERENCIA
INSERT INTO GERENCIA (ID, NOME_ACADEMIA, CNPJ, SENHA)
VALUES
  (1, 'Nome da Academia', '12345678901234', 'Mateus!@#123'),
  (2, 'Gym Name', '12345678901234', 'Mateus!@#123'),
  (3, 'Fitness Center', '98765432109876', 'securepass456'),
  (4, 'Health Club', '45678901234567', 'strongpass789'),
  (5, 'Sports Complex', '78901234567890', 'safeandstrong987');

-- INSERIR DADOS NA TABELA BASE_USER PARA OS INSTRUTORES
INSERT INTO BASE_USER (UID, NOME, EMAIL, NIVEL)
VALUES
  ('XvNZvA1lTuYI9MotBjIUcq2YyNc2', 'Rafael Oliveira', 'rafael@gmail.com', 1),
  ('JgbNIl3WsmfTS1MHva5enxOwztC2', 'Paula Souza', 'paula.souza@gmail.com', 1),
  ('bSc7d2IUT0eiZalN1PzA9RVEmSt1', 'Fernando Costa', 'fernando.costa@gmail.com', 1);

-- INSERIR DADOS NA TABELA INSTRUTOR
INSERT INTO INSTRUTOR (ID, HORARIO, SENHA_TEMPORARIA, GERENCIA_ID)
VALUES
  (6, '09:00-11:00', 'Mateus!@#123',1),
  (7, '14:00-16:00', 'Mateus!@#123',2),
  (8, '11:00-13:00', 'Mateus!@#123',2);

-- INSERIR DADOS NA TABELA BASE_USER PARA O ALUNO
INSERT INTO BASE_USER (UID, NOME, EMAIL, NIVEL)
VALUES
  ('Il8VD3dz5EXPTC2r2gnpJHXkpZi2', 'João Felix', 'joaoFelix@gmail.com', 2),
  ('3KwtSgBzRSZRLzIfPXnNXL6LlKl2', 'Kleber Ferraz', 'kleber@gmail.com', 2);

-- INSERIR DADOS NA TABELA ALUNO
INSERT INTO ALUNO (ID,GERENCIA_ID)
VALUES
    (9, 2),
    (10, 2);

-- INSERIR DADOS NA TABELA FEEDBACK
INSERT INTO Feedback (INSTRUTOR_AVALIADO_ID, ALUNO_AVALIADOR_ID, CLASSIFICACAO, COMENTARIO, DATA_CRIACAO)
VALUES
  (8, 9, 4.5, 'Ótimo instrutor!', '2023-10-25'),
  (8, 10, 3.0, 'Bom trabalho, mas pode melhorar.', '2023-10-25');

-- INSERIR DADOS NA TABELA AVALIACAO_FISICA
INSERT INTO AVALIACAO_FISICA (INSTRUTOR_ID, ALUNO_ID, DATA_AVALIACAO, HORARIO_AVALIACAO)
VALUES
  (7, 9, '2023-10-25', '09:00:00'),
  (7, 10, '2023-10-25', '10:00:00'),
  (7, 10, '2023-11-01', '10:00:00');

-- INSERIR DADOS NA TABELA CHAMADO
INSERT INTO CHAMADO (ALUNO_ID, STATUS_CHAMADOS, DATA_CRIACAO, HORARIO_CONCLUSAO, INSTRUTOR_ID)
VALUES
  (9, 0, '2023-10-25', null, 7),
  (10, 0, '2023-10-25', null, 8);

  -- INSERIR VALORES NA TABELA DE LOG

INSERT INTO LOG_USUARIO (BASE_USER_ID, DATA_LOGIN, HORARIO_LOGIN)
VALUES
    (9, '2023-10-27', '2023-10-27 05:39:30.843486'),
    (9, '2023-10-28', '2023-10-28 08:15:12.123456'),
    (9, '2023-10-29', '2023-10-29 12:30:45.654321'),
    (9, '2023-10-30', '2023-10-30 15:45:01.987654'),
    (9, '2023-10-31', '2023-10-31 18:00:00.000000'),
    (9, '2023-11-01', '2023-11-01 20:15:30.999999'),
    (9, '2023-11-02', '2023-11-02 22:30:15.111111'),
    (9, '2023-11-03', '2023-11-03 02:45:45.222222'),
    (9, '2023-11-04', '2023-11-04 05:00:05.333333'),
    (9, '2023-11-05', '2023-11-05 07:15:25.444444'),
    (9, '2023-11-06', '2023-11-06 09:30:35.555555'),
    (9, '2023-11-07', '2023-11-07 11:45:50.666666'),
    (9, '2023-11-08', '2023-11-08 14:00:10.777777'),
    (9, '2023-11-09', '2023-11-09 16:15:20.888888'),
    (9, '2023-11-10', '2023-11-10 18:30:30.999999'),
    (9, '2023-11-11', '2023-11-11 20:45:40.111111'),
    (9, '2023-11-12', '2023-11-12 23:00:50.222222'),
    (9, '2023-11-13', '2023-11-13 01:15:00.333333'),
    (9, '2023-11-14', '2023-11-14 03:30:10.444444'),
    (9, '2023-11-15', '2023-11-15 05:45:20.555555'),
    (9, '2023-11-16', '2023-11-16 08:00:30.666666'),
    (9, '2023-11-17', '2023-11-17 10:15:40.777777'),
    (9, '2023-11-18', '2023-11-18 12:30:50.888888'),
    (9, '2023-11-19', '2023-11-19 14:45:00.999999'),
    (9, '2023-11-20', '2023-11-20 17:00:11.111111'),
    (9, '2023-11-21', '2023-11-21 19:15:21.222222'),
    (9, '2023-11-22', '2023-11-22 21:30:31.333333'),
    (9, '2023-11-23', '2023-11-23 23:45:41.444444'),
    (9, '2023-11-24', '2023-11-24 02:00:51.555555'),
    (9, '2023-11-25', '2023-11-25 04:15:01.666666'),
    (9, '2023-11-26', '2023-11-26 06:30:11.777777'),
    (9, '2023-11-27', '2023-11-27 08:45:21.888888'),
    (9, '2023-11-28', '2023-11-28 11:00:31.999999'),
    (9, '2023-11-29', '2023-11-29 13:15:42.111111'),
    (9, '2023-11-30', '2023-11-30 15:30:52.222222'),
    (9, '2023-10-27', '2023-10-27 08:15:30.843486'),
    (9, '2023-10-27', '2023-10-27 10:23:12.234567'),
    (9, '2023-10-27', '2023-10-27 14:05:45.654321'),
    (9, '2023-10-27', '2023-10-27 16:42:01.987654'),
    (9, '2023-10-27', '2023-10-27 18:57:00.000000'),
    (9, '2023-10-27', '2023-10-27 20:23:30.999999'),
    (9, '2023-10-27', '2023-10-27 22:00:00.000000'), -- Repetindo o horário 22:00
    (9, '2023-10-27', '2023-10-27 22:00:00.000000'), -- Repetindo o horário 22:00
    (9, '2023-10-28', '2023-10-28 06:10:15.111111'),
    (9, '2023-10-28', '2023-10-28 09:00:30.333333'),
    (9, '2023-10-28', '2023-10-28 11:45:55.444444'),
    (9, '2023-10-28', '2023-10-28 14:20:10.555555'),
    (9, '2023-10-28', '2023-10-28 16:35:25.666666'),
    (9, '2023-10-28', '2023-10-28 19:00:40.777777'),
    (9, '2023-10-28', '2023-10-28 22:00:00.000000'), -- Repetindo o horário 22:00
    (9, '2023-10-28', '2023-10-28 22:00:00.000000'), -- Repetindo o horário 22:00
    (9, '2023-10-29', '2023-10-29 08:30:50.888888'),
    (9, '2023-10-29', '2023-10-29 10:15:05.999999'),
    (9, '2023-10-29', '2023-10-29 13:00:20.111111'),
    (9, '2023-10-29', '2023-10-29 15:25:35.222222'),
    (9, '2023-10-29', '2023-10-29 17:50:50.333333'),
    (9, '2023-10-29', '2023-10-29 20:15:05.444444'),
    (9, '2023-10-29', '2023-10-29 22:00:00.000000'), -- Repetindo o horário 22:00
    (9, '2023-10-29', '2023-10-29 22:00:00.000000'), -- Repetindo o horário 22:00
    (9, '2023-10-30', '2023-10-30 07:40:20.555555'),
    (9, '2023-10-30', '2023-10-30 09:55:35.666666'),
    (9, '2023-10-30', '2023-10-30 12:20:50.777777'),
    (9, '2023-10-30', '2023-10-30 14:45:05.888888'),
    (9, '2023-10-30', '2023-10-30 17:10:20.999999'),
    (9, '2023-10-30', '2023-10-30 19:35:36.111111'),
    (9, '2023-10-30', '2023-10-30 22:00:00.000000'), -- Repetindo o horário 22:00
    (9, '2023-10-30', '2023-10-30 22:00:00.000000'), -- Repetindo o horário 22:00
    (9, '2023-10-31', '2023-10-31 08:00:51.222222'),
    (9, '2023-10-31', '2023-10-31 10:25:06.333333'),
    (9, '2023-11-07', '2023-11-07 07:30:25.555555'),
    (9, '2023-11-07', '2023-11-07 10:00:40.666666'),
    (9, '2023-11-07', '2023-11-07 12:30:55.777777'),
    (9, '2023-11-07', '2023-11-07 15:00:10.888888'),
    (9, '2023-11-07', '2023-11-07 17:30:26.999999'),
    (9, '2023-11-07', '2023-11-07 20:00:42.111111'),
    (9, '2023-11-08', '2023-11-08 08:30:57.222222'),
    (9, '2023-11-08', '2023-11-08 11:00:12.333333'),
    (9, '2023-11-08', '2023-11-08 13:30:27.444444'),
    (9, '2023-11-08', '2023-11-08 16:00:42.555555'),
    (9, '2023-11-08', '2023-11-08 18:30:57.666666'),
    (9, '2023-11-08', '2023-11-08 21:00:12.777777'),
    (9, '2023-11-09', '2023-11-09 09:30:27.888888'),
    (9, '2023-11-09', '2023-11-09 12:00:43.999999'),
    (9, '2023-11-09', '2023-11-09 14:30:59.111111'),
    (9, '2023-11-09', '2023-11-09 17:00:14.222222'),
    (9, '2023-11-09', '2023-11-09 19:30:29.333333'),
    (9, '2023-11-09', '2023-11-09 22:00:44.444444'),
    (9, '2023-11-10', '2023-11-10 10:30:59.555555'),
    (9, '2023-11-10', '2023-11-10 13:00:14.666666'),
    (9, '2023-11-10', '2023-11-10 15:30:29.777777'),
    (9, '2023-11-10', '2023-11-10 18:00:44.888888'),
    (9, '2023-11-10', '2023-11-10 20:30:00.999999'),
    (9, '2023-11-10', '2023-11-10 23:00:16.111111'),
    (9, '2023-11-11', '2023-11-11 11:30:31.222222'),
    (9, '2023-11-11', '2023-11-11 14:00:46.333333'),
    (9, '2023-11-11', '2023-11-11 16:30:01.444444'),
    (9, '2023-11-11', '2023-11-11 19:00:16.555555'),
    (9, '2023-11-11', '2023-11-11 21:30:31.666666'),
    (9, '2023-11-11', '2023-11-11 23:59:46.777777'),
    (9, '2023-11-12', '2023-11-12 09:30:01.888888'),
    (9, '2023-11-12', '2023-11-12 12:00:17.999999'),
    (9, '2023-11-12', '2023-11-12 14:30:33.111111'),
    (9, '2023-11-12', '2023-11-12 17:00:48.222222'),
    (9, '2023-11-12', '2023-11-12 19:30:03.333333'),
    (9, '2023-11-12', '2023-11-12 22:00:18.444444'),
    (9, '2023-11-13', '2023-11-13 10:30:33.555555'),
    (9, '2023-11-13', '2023-11-13 13:00:48.666666'),
    (9, '2023-11-13', '2023-11-13 15:30:03.777777'),
    (9, '2023-11-13', '2023-11-13 18:00:18.888888'),
    (9, '2023-11-13', '2023-11-13 20:30:34.999999'),
    (9, '2023-11-13', '2023-11-13 23:00:50.111111'),
    (9, '2023-11-14', '2023-11-14 11:30:05.222222'),
    (9, '2023-11-14', '2023-11-14 14:00:20.333333'),
    (9, '2023-11-14', '2023-11-14 16:30:35.444444'),
    (9, '2023-11-14', '2023-11-14 19:00:50.555555'),
    (9, '2023-11-01', '2023-11-01 12:40:21.444444'),
    (9, '2023-11-01', '2023-11-01 15:05:36.555555'),
    (9, '2023-11-01', '2023-11-01 17:30:51.666666'),
    (9, '2023-11-02', '2023-11-02 07:50:06.777777'),
    (9, '2023-11-02', '2023-11-02 10:15:21.888888'),
    (9, '2023-11-02', '2023-11-02 12:40:36.999999'),
    (9, '2023-11-02', '2023-11-02 15:05:52.111111'),
    (9, '2023-11-02', '2023-11-02 17:30:07.222222'),
    (9, '2023-11-03', '2023-11-03 08:00:22.333333'),
    (9, '2023-11-03', '2023-11-03 10:25:37.444444'),
    (9, '2023-11-03', '2023-11-03 12:50:52.555555'),
    (9, '2023-11-03', '2023-11-03 15:15:07.666666'),
    (9, '2023-11-03', '2023-11-03 17:40:22.777777'),
    (9, '2023-11-04', '2023-11-04 09:10:37.888888'),
    (9, '2023-11-04', '2023-11-04 11:35:52.999999'),
    (9, '2023-11-04', '2023-11-04 14:00:08.111111'),
    (9, '2023-11-04', '2023-11-04 16:25:23.222222'),
    (9, '2023-11-04', '2023-11-04 18:50:38.333333'),
    (9, '2023-11-05', '2023-11-05 10:20:53.444444'),
    (9, '2023-11-05', '2023-11-05 12:45:08.555555'),
    (9, '2023-11-05', '2023-11-05 15:10:23.666666'),
    (9, '2023-11-05', '2023-11-05 17:35:38.777777'),
    (9, '2023-11-05', '2023-11-05 20:00:53.888888'),
    (9, '2023-11-06', '2023-11-06 08:30:09.999999'),
    (9, '2023-11-06', '2023-11-06 10:55:25.111111'),
    (9, '2023-11-06', '2023-11-06 13:20:40.222222'),
    (9, '2023-11-06', '2023-11-06 15:45:55.333333'),
    (9, '2023-11-06', '2023-11-06 18:10:10.444444'),
    (9, '2023-11-15', '2023-11-15 06:30:00.000000'),
    (9, '2023-11-15', '2023-11-15 08:15:00.000000'),
    (9, '2023-11-15', '2023-11-15 10:00:00.000000'),
    (9, '2023-11-15', '2023-11-15 12:00:00.000000'),
    (9, '2023-11-15', '2023-11-15 14:15:00.000000'),
    (9, '2023-11-15', '2023-11-15 16:30:00.000000'),
    (9, '2023-11-15', '2023-11-15 18:45:00.000000'),
    (9, '2023-11-15', '2023-11-15 20:30:00.000000'),
    (9, '2023-11-15', '2023-11-15 22:00:00.000000'),
    (9, '2023-11-15', '2023-11-15 10:45:00.000000'),
    (9, '2023-11-15', '2023-11-15 16:00:00.000000'),
    (9, '2023-11-15', '2023-11-15 20:15:00.000000'),
    (9, '2023-11-15', '2023-11-15 22:00:00.000000'),
    (9, '2023-11-15', '2023-11-15 14:30:00.000000'),
    (9, '2023-11-15', '2023-11-15 18:45:00.000000'),
    (9, '2023-11-15', '2023-11-15 06:30:00.000000'),
    (9, '2023-11-15', '2023-11-15 08:15:00.000000'),
    (9, '2023-11-15', '2023-11-15 10:00:00.000000'),
    (9, '2023-11-15', '2023-11-15 12:00:00.000000'),
    (9, '2023-11-15', '2023-11-15 14:15:00.000000'),
    (9, '2023-11-15', '2023-11-15 16:30:00.000000'),
    (9, '2023-11-15', '2023-11-15 18:45:00.000000'),
    (9, '2023-11-15', '2023-11-15 20:30:00.000000'),
    (9, '2023-11-15', '2023-11-15 22:00:00.000000'),
    (9, '2023-11-15', '2023-11-15 10:45:00.000000'),
    (9, '2023-11-15', '2023-11-15 16:00:00.000000'),
    (9, '2023-11-15', '2023-11-15 20:15:00.000000'),
    (9, '2023-11-15', '2023-11-15 22:00:00.000000'),
    (9, '2023-11-15', '2023-11-15 14:30:00.000000'),
    (9, '2023-11-15', '2023-11-15 18:45:00.000000'),
    (9, '2023-11-15', '2023-11-15 06:30:00.000000'),
    (9, '2023-11-15', '2023-11-15 08:15:00.000000'),
    (9, '2023-11-15', '2023-11-15 10:00:00.000000'),
    (9, '2023-11-15', '2023-11-15 12:00:00.000000'),
    (9, '2023-11-15', '2023-11-15 14:15:00.000000'),
    (9, '2023-11-15', '2023-11-15 16:30:00.000000'),
    (9, '2023-11-15', '2023-11-15 18:45:00.000000'),
    (9, '2023-11-15', '2023-11-15 20:30:00.000000'),
    (9, '2023-11-15', '2023-11-15 22:00:00.000000'),
    (9, '2023-11-15', '2023-11-15 10:45:00.000000'),
    (9, '2023-11-15', '2023-11-15 16:00:00.000000'),
    (9, '2023-11-15', '2023-11-15 20:15:00.000000'),
    (9, '2023-11-15', '2023-11-15 22:00:00.000000'),
    (9, '2023-11-15', '2023-11-15 14:30:00.000000'),
    (9, '2023-11-15', '2023-11-15 18:45:00.000000');







