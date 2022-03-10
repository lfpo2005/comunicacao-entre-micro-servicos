/*select nome AS "Nome do Aluno",
       idade AS "Idade do Aluno",
       matricula AS "Data da matricula"
from aluno;*/

SELECT *
    FROM aluno
    WHERE nome LIKE 'f%';


/*SELECT *
    FROM aluno
    WHERE cpf IS NOT NULL;*/

CREATE TABLE curso(
    id INTEGER PRIMARY KEY ,
    nome VARCHAR(255) NOT NULL);

select  * from curso;

insert  into curso (id, nome) values (01, 'java');

insert  into curso (id, nome) values (01, 'java');
insert  into curso (id, nome) values (02, 'javascript');
insert  into curso (id, nome) values (03, 'php');

CREATE TABLE aluno(
    id SERIAL PRIMARY KEY,
    nome VARCHAR
);
SELECT * FROM aluno;
SELECT  * FROM curso;
SELECT  * FROM aluno_curso;


INSERT INTO aluno(nome) VALUES ('Fernando');
INSERT INTO aluno(nome) VALUES ('Carla');
INSERT INTO aluno(nome) VALUES ('Lorenna');
INSERT INTO aluno(nome) VALUES ('Felipe');

CREATE TABLE aluno_curso(
    aluno_id INTEGER,
    curso_id INTEGER,
    PRIMARY KEY (aluno_id, curso_id),

    FOREIGN KEY (aluno_id)
    REFERENCES aluno(id),

    FOREIGN KEY (curso_id)
    REFERENCES curso(id)
);
INSERT INTO  aluno_curso(aluno_id, curso_id) VALUES (1, 1);
INSERT INTO  aluno_curso(aluno_id, curso_id) VALUES (1, 2);
INSERT INTO  aluno_curso(aluno_id, curso_id) VALUES (2, 2);

SELECT * FROM aluno
    JOIN aluno_curso ON aluno.id = aluno_id
    JOIN curso ON  curso.id = aluno_curso.curso_id;

SELECT aluno.nome as "Nome do ALuno",
       curso.nome as "Nome de Curso"
FROM aluno
    JOIN aluno_curso ON aluno.id = aluno_id
    JOIN curso ON  curso.id = aluno_curso.curso_id;

SELECT aluno.nome as "Nome do ALuno",
       curso.nome as "Nome de Curso"
FROM aluno
    LEFT JOIN  aluno_curso ON aluno.id = aluno_id
    LEFT JOIN curso ON  curso.id = aluno_curso.curso_id;

SELECT aluno.nome as "Nome do ALuno",
       curso.nome as "Nome de Curso"
FROM aluno
    RIGHT JOIN  aluno_curso ON aluno.id = aluno_id
    RIGHT JOIN curso ON  curso.id = aluno_curso.curso_id;

SELECT aluno.nome as "Nome do ALuno",
       curso.nome as "Nome de Curso"
FROM aluno
    FULL JOIN  aluno_curso ON aluno.id = aluno_id
    FULL JOIN curso ON  curso.id = aluno_curso.curso_id;


 drop table  curso;
 drop table  aluno;