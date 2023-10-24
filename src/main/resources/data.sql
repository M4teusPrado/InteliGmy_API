-- INSERIR DADOS NA TABELA BASE_USER PARA A GERENCIA
INSERT INTO BASE_USER (UID, NOME, EMAIL, NIVEL)
VALUES
  ('c7PtkoKRVpfUWcRVPgigIy3IV262', 'Mateus Prado', 'mateus.silvaprado@gmail.com', 0),
  ('c7PtkoKRVpfUWcRVPgigIy3IV263', 'José Silva', 'jose.silva@example.com', 0),
  ('c7PtkoKRVpfUWcRVPgigIy3IV264', 'Maria Oliveira', 'maria.oliveira@example.com', 0),
  ('c7PtkoKRVpfUWcRVPgigIy3IV265', 'Carlos Santos', 'carlos.santos@example.com', 0),
  ('c7PtkoKRVpfUWcRVPgigIy3IV266', 'Ana Pereira', 'ana.pereira@example.com', 0);

-- INSERIR DADOS NA TABELA GERENCIA
INSERT INTO GERENCIA (ID, NOME_ACADEMIA, CNPJ, SENHA)
VALUES
  (1, 'Nome da Academia', '12345678901234', 'senha123'),
  (2, 'Gym Name', '12345678901234', 'password123'),
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