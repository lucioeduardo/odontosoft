/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontosoft.model.domain;

import java.sql.Date;


/**
 *
 * @author Aluno
 */
public class Consulta {
    private int paciente;
    private int dentista;
    private Date data;

    public Consulta(int paciente, int dentista, Date data) {
        this.dentista = dentista;
        this.paciente = paciente;
        this.data = data;
    }


    public int getDentista() {
        return dentista;
    }

    public void setDentista(int dentista) {
        this.dentista = dentista;
    }

    public int getPaciente() {
        return paciente;
    }

    public void setPaciente(int paciente) {
        this.paciente = paciente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
}
