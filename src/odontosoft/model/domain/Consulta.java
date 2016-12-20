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
    private int paciente;
    private int dentista;
    private Calendar data;
    
    
    

    public Consulta(int paciente, int dentista, Calendar data) {
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

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }
    
    
}
