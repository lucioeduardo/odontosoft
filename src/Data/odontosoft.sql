CREATE DATABASE IF NOT EXISTS odontosoft;
USE odontosoft;

CREATE TABLE IF NOT EXISTS Paciente(
    id int primary key auto_increment,
    nome varchar(100) not null,
    dataNascimento date not null,
    cpf varchar(11) not null unique,
    telefone varchar(11) not null unique
);

CREATE TABLE IF NOT EXISTS Funcionario(
    id int primary key auto_increment,
    nome varchar(100) not null,
    cpf varchar(11) not null unique,
    telefone varchar(11) not null unique,
    dataNascimento date not null,
    rg varchar(45) unique,
    salario double not null,
    isGerente bool not null,
    isDentista bool not null
);

CREATE TABLE IF NOT EXISTS Procedimento(
    id int primary key auto_increment,
    descricao varchar(100) not null,
    preco double not null
);

CREATE TABLE IF NOT EXISTS Usuario(
    id varchar(50) not null unique primary key,
    senha varchar(45) not null,
    idFuncionario int not null,
    FOREIGN KEY (idFuncionario)
	REFERENCES Funcionario(id)
);

CREATE TABLE IF NOT EXISTS Consulta(
    id int primary key auto_increment,
    idPaciente int not null,
    idFuncionario int not null,
    dataConsulta date,
    FOREIGN KEY (idPaciente)
	REFERENCES Paciente(id),
    FOREIGN KEY (idFuncionario)
	REFERENCES Funcionario(id)
);

CREATE TABLE IF NOT EXISTS Consulta_has_Procedimento(
    idConsulta int not null,
    idProcedimento int not null,
    FOREIGN KEY (idConsulta)
	REFERENCES Consulta(id),
    FOREIGN KEY (idProcedimento)
	REFERENCES Procedimento(id),
    PRIMARY KEY (idConsulta, idProcedimento)
);

INSERT INTO Funcionario(nome, cpf, telefone, dataNascimento, rg, salario, isGerente, isDentista) VALUES ("admin", "0", "0", "2016/12/01", "0", 0, TRUE, FALSE);
INSERT INTO Usuario(id, senha, idFuncionario) VALUES ("adminadmin", "admin", 1);

/*DELIMITER //
CREATE FUNCTION returnId (_cpf varchar(11)) RETURNS INT
	BEGIN
	
    RETURN (SELECT id FROM Funcionario WHERE cpf = _cpf);
    END
//
DELIMITER ;*/