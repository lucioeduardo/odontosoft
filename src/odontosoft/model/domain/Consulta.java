/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontosoft.model.domain;

import java.util.Calendar;


/**
 *
 * @author Aluno
 */
public class Consulta {
    private int id,idPaciente;
    private int idDentista;
    private Calendar data;
    
    
    

    public Consulta(int id, int paciente, int dentista, Calendar data) {
        this.idDentista = dentista;
        this.idPaciente = paciente;
        this.data = data;
        this.id = id;
    }


    public int getDentista() {
        return idDentista;
    }

    public void setDentista(int dentista) {
        this.idDentista = dentista;
    }

    public int getPaciente() {
        return idPaciente;
    }

    public void setPaciente(int paciente) {
        this.idPaciente = paciente;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }
    
    
}
