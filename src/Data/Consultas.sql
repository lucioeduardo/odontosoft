CREATE FUNCTION returnId (varchar(11) _cpf){
    SELECT cpf FROM Funcionario WHERE cpf = _cpf;
}

