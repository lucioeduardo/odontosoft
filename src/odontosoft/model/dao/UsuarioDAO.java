package odontosoft.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import odontosoft.model.domain.Usuario;

public class UsuarioDAO implements InterfaceGenericDAO<Usuario,String> {
    Connection conexao;
    
    public UsuarioDAO(Connection conexao){
        this.conexao = conexao;
    }

    @Override
    public void inserir(Usuario user) {
        String sql = "insert into Usuario (id,senha,idFuncionario) values (?,?,?)";
        PreparedStatement stmt = null;
        
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, user.getId());
            stmt.setString(2, user.getSenha());
            stmt.setInt(3, user.getIdFuncionario());
            
            stmt.execute();
            stmt.close();
            System.out.println("Dados inseridos no banco de dados!");
        }catch(SQLException e){
            System.out.println("Erro na inserção dos dados!");
        }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList();
        String sql = "select * from Usuario";
        
        try{
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Usuario u = new Usuario(rs.getString("id"), rs.getString("senha"), rs.getInt("idFuncionario"));
                lista.add(u);
            }
            rs.close();
            stmt.close();
        }catch(SQLException E){
            System.out.println("Erro na consulta de usuarios!");
        }
        
        return lista;
    }

    @Override
    public void delete(String id) {
        String sql = "delete from Usuario where id=?";
        
        try{
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            System.out.println("Erro ao deletar usuario!");
        }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(String id, Usuario novoUsuario) {
        String sql = "update Usuario set id=? nome=? idFuncionario=? where id=?";
        
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, novoUsuario.getId());
            stmt.setString(2, novoUsuario.getSenha());
            stmt.setInt(3, novoUsuario.getIdFuncionario());
            stmt.setString(4, id);
            
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Usuario buscaPorId(String id) {
        String sql = "select * from Usuario where id = ?";
        Usuario user = null;
        
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, id);
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
                user = new Usuario(rs.getString("id"), rs.getString("senha"),rs.getInt("idFuncionario"));
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    
}
