CREATE DATABASE IF NOT EXISTS odontosoft;
USE odontosoft;

CREATE TABLE Paciente(
    idPaciente int primary key auto_increment,
    nome varchar(100) not null,
    dataNascimento date not null,
    cpf varchar(11) not null unique,
    telefone varchar(11) not null unique,
    foto varchar(45) not null
);

CREATE TABLE Funcionario(
    idFuncionario int primary key auto_increment,
    nome varchar(100) not null,
    cpf varchar(11) not null unique,
    telefone varchar(11) not null unique,
    dataNascimento date not null,
    rg varchar(45) unique,
    salario double not null,
    isGerente bool not null  
);

CREATE TABLE Procedimento(
    idProcedimento int primary key auto_increment,
    descricao varchar(100) not null,
    preco double not null
);

CREATE TABLE Usuario(
    id varchar(50) not null unique primary key,
    senha varchar(45) not null,
    Funcionario_idFuncionario int not null,
    FOREIGN KEY (Funcionario_idFuncionario)
	REFERENCES Funcionario(idFuncionario)
);

CREATE TABLE Consulta(
    idConsulta int primary key auto_increment,
    Paciente_idPaciente int not null,
    Funcionario_idFuncionario int not null,
    dataConsulta date,
    FOREIGN KEY (Paciente_idPaciente)
	REFERENCES Paciente(idPaciente),
    FOREIGN KEY (Funcionario_idFuncionario)
	REFERENCES Funcionario(idFuncionario)
);

CREATE TABLE Consulta_has_Procedimento(
    Consulta_idConsulta int not null,
    Procedimento_idProcedimento int not null,
    FOREIGN KEY (Consulta_idConsulta)
	REFERENCES Consulta(idConsulta),
    FOREIGN KEY (Procedimento_idProcedimento)
	REFERENCES Procedimento(idProcedimento)
);