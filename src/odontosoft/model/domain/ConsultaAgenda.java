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
    private String nomePaciente,nomeDentista,data,horario;
    int idConsulta;

    public ConsultaAgenda(int idConsulta, String nomePaciente, String nomeDentista, String data, String horario) {
        this.nomePaciente = nomePaciente;
        this.nomeDentista = nomeDentista;
        this.data = data;
        this.horario = horario;
        this.idConsulta = idConsulta;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getNomeDentista() {
        return nomeDentista;
    }

    public void setNomeDentista(String nomeDentista) {
        this.nomeDentista = nomeDentista;
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
    
    
}
