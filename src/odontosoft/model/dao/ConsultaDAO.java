
package odontosoft.model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import odontosoft.model.database.ConexaoBanco;
import odontosoft.model.domain.Consulta;
import odontosoft.model.domain.ConsultaAgenda;

public class ConsultaDAO implements InterfaceGenericDAO<Consulta, Integer> {

    ConexaoBanco conexao = new ConexaoBanco();
    Connection connect = conexao.getConexao();
    PreparedStatement stmt = null;
    PacienteDAO pacienteDao = new PacienteDAO(conexao);
    FuncionarioDAO funcionarioDao = new FuncionarioDAO(conexao);

    public ConsultaDAO() {

    }

    @Override
    public void inserir(Consulta var) {
        String sql = "INSERT INTO Consulta(idPaciente, idFuncionario, dataConsulta) VALUES (?,?,?);";
        try {
            stmt = connect.prepareStatement(sql);
            stmt.setInt(1, var.getIdPaciente());
            stmt.setInt(2, var.getIdDentista());

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

                list.add(new Consulta(rs.getInt("id"),rs.getInt("idPaciente"), rs.getInt("idFuncionario"), data));

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
        String sql = "UPDATE Consulta SET idPaciente = ?, idFuncionario = ?, dataConsulta=? WHERE id = ?;";
        try {
            stmt = connect.prepareStatement(sql);
            stmt.setInt(1, newVar.getIdPaciente());
            stmt.setInt(2, newVar.getIdDentista());
            stmt.setTimestamp(3, new Timestamp(newVar.getData().getTimeInMillis()));
            stmt.setInt(4, id);

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

                var = new Consulta(rs.getInt("id"),rs.getInt("idPaciente"), rs.getInt("idFuncionario"), data);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return var;
    }
    
    /*
    * Método que retorna uma lista com todas as consultas do dia
    */
    public ObservableList<ConsultaAgenda> getAgendaDoDia() {
        ResultSet rs;
        ObservableList<ConsultaAgenda> list = FXCollections.observableArrayList();
        String sql = "select Consulta.id as idConsulta, Paciente.id as idPaciente,Funcionario.id as idFuncionario,Consulta.dataConsulta from Consulta inner join Paciente inner join Funcionario where Date(Consulta.dataConsulta) = Date(now()) and Consulta.idPaciente = Paciente.id and Consulta.idFuncionario = Funcionario.id order by Consulta.dataConsulta;";
        try {
            stmt = connect.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idPaciente = rs.getInt("idPaciente");
                int idDentista = rs.getInt("idFuncionario");
                int idConsulta = rs.getInt("idConsulta");
                Calendar data = new GregorianCalendar();
                data.setTimeInMillis(rs.getTimestamp("dataConsulta").getTime());

                SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
                String dataStr = formatData.format(data.getTime());
                
                String horario = data.get(Calendar.HOUR_OF_DAY) + ":" + data.get(Calendar.MINUTE);

                
                
                list.add(new ConsultaAgenda(pacienteDao.buscaPorId(idPaciente), funcionarioDao.buscaPorId(idDentista), dataStr, horario,idConsulta));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return list;
    }

    public ObservableList<ConsultaAgenda> getAgendaCompleta() {
        ResultSet rs;
        ObservableList<ConsultaAgenda> list = FXCollections.observableArrayList();
        String sql = "select Consulta.id as idConsulta, Paciente.id as idPaciente,Funcionario.id as idFuncionario,Consulta.dataConsulta from Consulta inner join Paciente inner join Funcionario where Consulta.dataConsulta > now() and Consulta.idPaciente = Paciente.id and Consulta.idFuncionario = Funcionario.id order by Consulta.dataConsulta;";
        try {
            stmt = connect.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idPaciente = rs.getInt("idPaciente");
                int idDentista = rs.getInt("idFuncionario");
                int idConsulta = rs.getInt("idConsulta");

                Calendar data = new GregorianCalendar();
                data.setTimeInMillis(rs.getTimestamp("dataConsulta").getTime());
                
                SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
                
                String dataStr = formatData.format(data.getTime());
                String horario = data.get(Calendar.HOUR_OF_DAY) + ":" + data.get(Calendar.MINUTE);

                list.add(new ConsultaAgenda(pacienteDao.buscaPorId(idPaciente), funcionarioDao.buscaPorId(idDentista), dataStr, horario,idConsulta));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return list;
    }
    
    public Consulta getProximaConsulta(){
        String sql = "SELECT * FROM Consulta WHERE dataConsulta >= now() and Date(dataConsulta)=Date(now()) ORDER BY dataConsulta LIMIT 1;";
        Consulta consulta = null;

        try {
            stmt = connect.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Calendar data = new GregorianCalendar();
                data.setTimeInMillis(rs.getTimestamp("dataConsulta").getTime());

                consulta = new Consulta(rs.getInt("id"),rs.getInt("idPaciente"), rs.getInt("idFuncionario"), data);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return consulta;
    }
    
    public Integer[] numeroDeConsultasPorMeses(){
        String sql = "select count(*) as qtd,Month(dataConsulta) as mes from Consulta group by Month(dataConsulta);";
        Integer[] contagem = new Integer[12];
        
        for(int i=0;i<12;i++) 
            contagem[i]=0;
        
        try {    
            stmt = connect.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                contagem[rs.getInt("mes")-1] = rs.getInt("qtd");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return contagem;
    }
    
    public Integer[] numeroDeConsultasPorDiaDaSemana(){
        String sql = "select count(*) as qtd,DAYOFWEEK(dataConsulta) as dia from Consulta group by DAYOFWEEK(dataConsulta);";
        Integer[] contagem = new Integer[7];
        
        for(int i=0;i<7;i++) 
            contagem[i]=0;
        
        try {    
            stmt = connect.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                contagem[rs.getInt("dia")-1] = rs.getInt("qtd");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return contagem;
    }
    
    

}
