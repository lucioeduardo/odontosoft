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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdDentista() {
        return idDentista;
    }

    public void setIdDentista(int idDentista) {
        this.idDentista = idDentista;
    }
    
    
    

    public Consulta(int id, int paciente, int dentista, Calendar data) {
        this.idDentista = dentista;
        this.idPaciente = paciente;
        this.data = data;
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }
    
    
}
