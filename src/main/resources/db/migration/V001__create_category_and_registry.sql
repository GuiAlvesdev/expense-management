CREATE TABLE categoria(
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL


)ENGINE=innoDB DEFAULT CHARSET=utf8;

INSERT INTO categoria(nome) values ('Lazer');
INSERT INTO categoria(nome) values ('Alimentacao');
INSERT INTO categoria(nome) values ('Contas Fixas');
INSERT INTO categoria(nome) values ('Despesas Gerais');
INSERT INTO categoria(nome) values ('Outros');
