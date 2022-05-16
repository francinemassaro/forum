INSERT INTO USUARIO(nome, email, senha) VALUES ('Aluno', 'aluno@email.com', '123456');

INSERT INTO CURSO (nome, categoria) VALUES ('Spring Boot', 'Programação');
INSERT INTO CURSO (nome, categoria) VALUES ('Clean Archtecture', 'Programação');

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES ('Dúvida', 'Erro ao criar projeto', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES ('Dúvida 2', 'Projeto não compila', '2019-05-05 19:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES ('Dúvida 3', 'Problemas com o map e flatmap', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 1, 2);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES ('Dúvida 4', 'Como percorrer o objeto', '2019-05-05 17:00:00', 'NAO_RESPONDIDO', 1, 2);