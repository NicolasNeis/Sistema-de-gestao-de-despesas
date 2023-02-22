DROP SCHEMA IF EXISTS financas;
CREATE SCHEMA financas;
USE financas;

DROP TABLE IF EXISTS categoria;

CREATE TABLE categoria (
	id int(11) NOT NULL AUTO_INCREMENT,
    descricao varchar(100) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO categoria VALUES (1, 'Alimentação'), (2, 'Educação'),
(3, 'Esporte'), (4, 'Lazer'), (5, 'Moradia'), (6, 'Outros'),
(7,'Presentes'), (8,'Roupas'), (9,'Salário'), (10,'Saúde'),
(11,'Transporte'), (12,'Viagem');



CREATE TABLE tipos_movimentacao (
	id int(11) NOT NULL AUTO_INCREMENT,
	descricao varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
);

INSERT INTO tipos_movimentacao VALUES (1,'Receita'),(2,'Despesa');

DROP TABLE IF EXISTS movimentacao;

CREATE TABLE movimentacao (
	id int(11) NOT NULL AUTO_INCREMENT,
	tipo int(11) NOT NULL,
	categoria int(11) NOT NULL,
	data date NOT NULL, 
	valor decimal(7,2) NOT NULL,
	descricao varchar(50) DEFAULT NULL,
	pago BOOLEAN NOT NULL,
	PRIMARY KEY (id),
	KEY fk_movimentacao_1_idx (tipo),
	KEY fk_categoria_idx (categoria),
	CONSTRAINT fk_categoria FOREIGN KEY (categoria) REFERENCES categoria (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT fk_tipo FOREIGN KEY (tipo) REFERENCES tipos_movimentacao (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

INSERT INTO movimentacao (tipo, categoria, data, valor, pago) VALUES (1, 9, now(), 5000, TRUE);

CREATE TABLE financas.usuario (
	id INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(45) NOT NULL UNIQUE,
	senha VARCHAR(6) NOT NULL,
	PRIMARY KEY (id)
);
  
INSERT INTO usuario (nome, senha) VALUES ('teste','1234');

SELECT * FROM usuario;
SELECT * FROM movimentacao;
