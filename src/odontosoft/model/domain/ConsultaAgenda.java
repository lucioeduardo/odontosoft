/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontosoft.model.domain;

/**
 *
 * @author eduardo
 * Classe utilizada para popular a TableViewAgenda
 */
public class ConsultaAgenda {
    private Paciente paciente;
    private Funcionario dentista;
    private String data,horario;
    int idConsulta;

    public ConsultaAgenda(Paciente paciente, Funcionario dentista, String data, String horario, int idConsulta) {
        this.paciente = paciente;
        this.dentista = dentista;
        this.data = data;
        this.horario = horario;
        this.idConsulta = idConsulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Funcionario getDentista() {
        return dentista;
    }

    public void setDentista(Funcionario dentista) {
        this.dentista = dentista;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

   
    
    
}
