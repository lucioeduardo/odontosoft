/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontosoft.model.domain;

/**
 *
 * @author mikolaja
 */
public class Consulta_has_Procedimento {
    private int idConsulta, idProcedimento,quantidade;

    public Consulta_has_Procedimento(int idConsulta, int idProcedimento, int quantidade) {
        this.idConsulta = idConsulta;
        this.idProcedimento = idProcedimento;
        this.quantidade = quantidade;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public int getIdProcedimento() {
        return idProcedimento;
    }

    public void setIdProcedimento(int idProcedimento) {
        this.idProcedimento = idProcedimento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    
    
}
