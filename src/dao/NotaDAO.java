package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import control.NotaBean;

public class NotaDAO {
	
	private NotaBean map(ResultSet rs) throws SQLException {
        NotaBean resultado = new NotaBean(rs.getInt("id"), rs.getInt("nota"), 
        		rs.getString("nome"), rs.getString("id_usuario"),
        		rs.getInt("id_fornecedor"));
        return resultado;
    }
	
	public void inserir(int nota, String descricao, String idUsuario, int idFornecedor) throws DAOException{
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String insert_sql = "insert into nota (nota, descricao, id_usuario, id_fornecedor) values (?, ?, ?, ?)";
            PreparedStatement pst;
            pst = con.prepareStatement(insert_sql);
            //Passando os paramentros para o SQL
            pst.setInt(1, nota);
            pst.setString(2, descricao);
            pst.setString(3, idUsuario);
            pst.setInt(4, idFornecedor);
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
	
	public void update(int id, int nota, String descricao, String idUsuario) throws DAOException{
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String insert_sql = "update nota set nota = ?, descricao = ? where id = ? and id_usuario = ?";
            PreparedStatement pst;
            pst = con.prepareStatement(insert_sql);
            //Passando os paramentros para o SQL
            pst.setInt(1, nota);
            pst.setString(2, descricao);
            pst.setInt(3, id);
            pst.setString(4, idUsuario);
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

    public void delete(int id, String idUsuario) throws DAOException{
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "delete from nota where id = ? and id_usuario = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, idUsuario);
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

	public NotaBean encontrar(int id, String idUsuario) throws DAOException{
        Connection con = null;
        NotaBean nota = null;
                
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from nota where id = ? and id_usuario = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, idUsuario);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
            	nota = map(rs);
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
        return nota;
    }
	
	public ArrayList<NotaBean> mostrarTodas() throws DAOException {
        Connection con = null;
        ArrayList<NotaBean> notas = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from nota";
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
            	notas.add(map(rs));
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
        return notas;
    }
	public ArrayList<NotaBean> mostrarNotasFornecedor(int idFornecedor) throws DAOException {
        Connection con = null;
        ArrayList<NotaBean> notas = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from nota where id_fornecedor = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idFornecedor);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
            	notas.add(map(rs));
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
        return notas;
    }
}
