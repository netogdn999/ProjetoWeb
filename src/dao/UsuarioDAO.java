package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import control.UsuarioBean;

public class UsuarioDAO {
	
	private UsuarioBean map(ResultSet rs) throws SQLException {
        UsuarioBean resultado = new UsuarioBean(rs.getInt("id_fornecedor"), rs.getString("nome"),
        		rs.getString("login"), rs.getString("senha"),
        		rs.getInt("privilegio"), rs.getString("setor"));
        return resultado;
    }
	
	public void inserir(int idFornecedor, String nome, String login, String senha, int privilegio, String setor) throws DAOException{
        Connection con = null;
        try {
            con = new ConnectionFactory().conectar("leilao");
            PreparedStatement pst;
            if(idFornecedor==0) {
            	String insert_sql = "insert into usuario (nome, login, senha, privilegio, setor) values (?, ?, ?, ?, ?)";
            	pst = con.prepareStatement(insert_sql);
            	//Passando os paramentros para o SQL
            	pst.setString(1, nome);
            	pst.setString(2, login);
            	pst.setString(3, senha);
            	pst.setInt(4, privilegio);
            	pst.setString(5, setor);
            	//Executando os comandos
            }else {
            	String insert_sql = "insert into usuario (nome, login, senha, privilegio, setor, id_fornecedor) values (?, ?, ?, ?, ?, ?)";
            	pst = con.prepareStatement(insert_sql);
            	//Passando os paramentros para o SQL
            	pst.setString(1, nome);
            	pst.setString(2, login);
            	pst.setString(3, senha);
            	pst.setInt(4, privilegio);
            	pst.setString(5, setor);
            	pst.setInt(6, idFornecedor);
            	//Executando os comandos
            }
            pst.executeUpdate();
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
            throw new DAOException("Opera��o n�o realizada com sucesso.", e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Não foi possível fechar a conexão.", e);
            }
        }
	}
	
	public void update(int idFornecedor, String nome, String login, String senha, int privilegio, String setor) throws DAOException{
        Connection con = null;
        try {
            con = new ConnectionFactory().conectar("leilao");
            String insert_sql = "update usuario set nome = ?, id_fornecedor = ?, senha = ?, privilegio = ?, setor = ? where login = ?";
            PreparedStatement pst;
            pst = con.prepareStatement(insert_sql);
            //Passando os paramentros para o SQL
            pst.setString(1, nome);
            pst.setInt(2, idFornecedor);
            pst.setString(3, senha);
            pst.setInt(4, privilegio);
            pst.setString(5, setor);
            pst.setString(6, login);
            //Executando os comandos
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Operação não realizada com sucesso.", e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Não foi possível fechar a conexão.", e);
            }
        }
    }

    public void delete(String login) throws DAOException{
        Connection con = null;
        try {
            con = new ConnectionFactory().conectar("leilao");
            String sql = "delete from usuario where login = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, login);
            pst.executeUpdate();
            pst.close();
            con.close();
        } catch (SQLException e) {
            throw new DAOException("Operação não realizada com sucesso.", e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Não foi possível fechar a conexão.", e);
            }
        }
    }

	public UsuarioBean encontrar(String login) throws DAOException{
		Connection con=null;
        UsuarioBean usuario = null;
                
        try {
        	con = new ConnectionFactory().conectar("leilao");
            String sql = "select * from usuario where login = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, login);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
            	usuario = map(rs);
            }
        } catch (SQLException e) {
            throw new DAOException("Operação não realizada com sucesso.", e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Não foi possível fechar a conexão.", e);
            }
        }
        return usuario;
    }
	
public UsuarioBean encontrar(int idFornecedor) throws DAOException{
		Connection con=null;
        UsuarioBean usuario = null;
                
        try {
        	con = new ConnectionFactory().conectar("leilao");
            String sql = "select * from usuario where id_fornecedor = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, idFornecedor);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
            	usuario = map(rs);
            }
        } catch (SQLException e) {
            throw new DAOException("Operação não realizada com sucesso.", e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Não foi possível fechar a conexão.", e);
            }
        }
        return usuario;
    }
	public ArrayList<UsuarioBean> mostrarTodos() throws DAOException {
        Connection con = null;
        ArrayList<UsuarioBean> usuarios = new ArrayList<>();
        try {
            con = new ConnectionFactory().conectar("leilao");
            String sql = "select * from usuario";
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
            	usuarios.add(map(rs));
            }
        } catch (SQLException e) {
            throw new DAOException("Operação não realizada com sucesso.", e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Não foi possível fechar a conexão.", e);
            }
        }
        return usuarios;
    }
}
