CREATE DATABASE IF NOT EXISTS odontosoft;
USE odontosoft;

CREATE TABLE Paciente(
    id int primary key auto_increment,
    nome varchar(100) not null,
    dataNascimento date not null,
    cpf varchar(11) not null unique,
    telefone varchar(11) not null unique,
    foto varchar(45) not null
);

CREATE TABLE Funcionario(
    id int primary key auto_increment,
    nome varchar(100) not null,
    cpf varchar(11) not null unique,
    telefone varchar(11) not null unique,
    dataNascimento date not null,
    rg varchar(45) unique,
    salario double not null,
    isGerente bool not null  
);

CREATE TABLE Procedimento(
    id int primary key auto_increment,
    descricao varchar(100) not null,
    preco double not null
);

CREATE TABLE Usuario(
    id varchar(50) not null unique primary key,
    senha varchar(45) not null,
    idFuncionario int not null,
    FOREIGN KEY (idFuncionario)
	REFERENCES Funcionario(id)
);

CREATE TABLE Consulta(
    id int primary key auto_increment,
    idPaciente int not null,
    idFuncionario int not null,
    dataConsulta date,
    FOREIGN KEY (idPaciente)
	REFERENCES Paciente(id),
    FOREIGN KEY (idFuncionario)
	REFERENCES Funcionario(id)
);

CREATE TABLE Consulta_has_Procedimento(
    idConsulta int not null,
    idProcedimento int not null,
    FOREIGN KEY (idConsulta)
	REFERENCES Consulta(id),
    FOREIGN KEY (idProcedimento)
	REFERENCES Procedimento(id),
    PRIMARY KEY (idConsulta, idProcedimento)
);