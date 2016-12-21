/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odontosoft.model.dao;

/**
 *
 * @author Aluno
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import odontosoft.model.database.ConexaoBanco;
import odontosoft.model.domain.Consulta;
import odontosoft.model.domain.ConsultaAgenda;

public class ConsultaDAO implements InterfaceGenericDAO<Consulta, Integer> {

    ConexaoBanco conexao = new ConexaoBanco();
    Connection connect = conexao.getConexao();
    PreparedStatement stmt = null;

    public ConsultaDAO() {

    }

    @Override
    public void inserir(Consulta var) {
        String sql = "INSERT INTO Consulta(idPaciente, idFuncionario, dataConsulta) VALUES (?,?,?);";
        try {
            stmt = connect.prepareStatement(sql);
            stmt.setInt(1, var.getPaciente());
            stmt.setInt(2, var.getDentista());

            System.out.println("Ano:" + var.getData().get(Calendar.YEAR));
            stmt.setTimestamp(3, new Timestamp(var.getData().getTimeInMillis()));

            stmt.execute();
            stmt.close();
            System.out.println("Dados inseridos no banco de dados!");
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    @Override
    public List<Consulta> listar() {
        ResultSet rs;
        List<Consulta> list = new ArrayList<>();
        String sql = "SELECT * FROM Consulta";
        try {
            stmt = connect.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Calendar data = new GregorianCalendar();
                data.setTimeInMillis(rs.getTimestamp("dataConsulta").getTime());

                list.add(new Consulta(rs.getInt("idPaciente"), rs.getInt("idFuncionario"), data));

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Consulta WHERE id = ?";
        try {
            stmt = connect.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
            System.out.println("Dados deletados com sucesso!");
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    @Override
    public void update(Integer id, Consulta newVar) {
        String sql = "UPDATE Consulta SET idPaciente = ?, idFuncionario = ? WHERE id = ?;";
        try {
            stmt = connect.prepareStatement(sql);
            stmt.setInt(1, newVar.getPaciente());
            stmt.setInt(2, newVar.getDentista());
            stmt.setInt(3, id);

            stmt.execute();
            stmt.close();
            System.out.println("Dados atualizados!");
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    @Override
    public Consulta buscaPorId(Integer id) {
        String sql = "SELECT * FROM Consulta WHERE id = ?";
        Consulta var = null;

        try {
            stmt = connect.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Calendar data = new GregorianCalendar();
                data.setTimeInMillis(rs.getTimestamp("dataConsulta").getTime());

                var = new Consulta(rs.getInt("idPaciente"), rs.getInt("idFuncionario"), data);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return var;
    }

    public ObservableList<ConsultaAgenda> getAgendaDoDia() {
        ResultSet rs;
        ObservableList<ConsultaAgenda> list = FXCollections.observableArrayList();
        String sql = "select Paciente.nome as nomePaciente,Funcionario.nome as nomeFuncionario,Consulta.dataConsulta from Consulta inner join Paciente inner join Funcionario where Date(Consulta.dataConsulta) = Date(now()) and Consulta.idPaciente = Paciente.id and Consulta.idFuncionario = Funcionario.id;";
        try {
            stmt = connect.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String nomePaciente = rs.getString("nomePaciente");
                String nomeDentista = rs.getString("nomeFuncionario");

                Calendar data = new GregorianCalendar();
                data.setTimeInMillis(rs.getTimestamp("dataConsulta").getTime());

                String dataStr = data.get(Calendar.DAY_OF_MONTH) + "/" + data.get(Calendar.MONTH)
                        + "/" + data.get(Calendar.YEAR);
                String horario = data.get(Calendar.HOUR_OF_DAY) + ":" + data.get(Calendar.MINUTE);

                list.add(new ConsultaAgenda(nomePaciente, nomeDentista, dataStr, horario));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        System.out.println(list.size());
        return list;
    }

    public ObservableList<ConsultaAgenda> getAgendaSemana() {
        ResultSet rs;
        ObservableList<ConsultaAgenda> list = FXCollections.observableArrayList();
        String sql = "select Paciente.nome as nomePaciente,Funcionario.nome as nomeFuncionario,Consulta.dataConsulta "
                + "from Consulta inner join Paciente inner join Funcionario where Date(Consulta.dataConsulta) "
                + "between Date(now()) and Date_Add(Date(now()), INTERVAL 1 WEEK) order by Consulta.dataConsulta";
        try {
            stmt = connect.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String nomePaciente = rs.getString("nomePaciente");
                String nomeDentista = rs.getString("nomeFuncionario");

                Calendar data = new GregorianCalendar();
                data.setTimeInMillis(rs.getTimestamp("dataConsulta").getTime());

                String dataStr = data.get(Calendar.DAY_OF_MONTH) + "/" + data.get(Calendar.MONTH)
                        + "/" + data.get(Calendar.YEAR);
                String horario = data.get(Calendar.HOUR) + ":" + data.get(Calendar.MINUTE);

                list.add(new ConsultaAgenda(nomePaciente, nomeDentista, dataStr, horario));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        System.out.println(list.size());
        return list;
    }

}
