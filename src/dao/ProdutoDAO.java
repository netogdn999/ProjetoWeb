package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import control.ProdutoBean;

public class ProdutoDAO {
	
	private ProdutoBean map(ResultSet rs) throws SQLException {
        ProdutoBean resultado = new ProdutoBean(rs.getInt("id"), rs.getString("nome"),
        		rs.getString("marca"), rs.getInt("id_categoria"));
        return resultado;
    }
	
	public void inserir(String nome, String marca, int idCategoria) throws DAOException{
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String insert_sql = "insert into produto (nome, marca, id_categoria) values (?, ?, ?)";
            PreparedStatement pst;
            pst = con.prepareStatement(insert_sql);
            //Passando os paramentros para o SQL
            pst.setString(1, nome);
            pst.setString(2, marca);
            pst.setInt(3, idCategoria);
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
	
	public void update(int id, String nome, String marca, int idCategoria) throws DAOException{
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String insert_sql = "update produto set nome = ?, marca = ?, id_categoria = ? where id = ?";
            PreparedStatement pst;
            pst = con.prepareStatement(insert_sql);
            //Passando os paramentros para o SQL
            pst.setString(1, nome);
            pst.setString(2, marca);
            pst.setInt(3, idCategoria);
            pst.setInt(4, id);
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

    public void delete(int id) throws DAOException{
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "delete from produto where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
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

	public ProdutoBean encontrar(int id) throws DAOException{
        Connection con = null;
        ProdutoBean prod = null;
                
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from produto where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                prod = map(rs);
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
        return prod;
    }
	
	public ArrayList<ProdutoBean> mostrarTodos() throws DAOException {
        Connection con = null;
        ArrayList<ProdutoBean> produtos = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from produto";
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                produtos.add(map(rs));
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
        return produtos;
    }
	public ArrayList<ProdutoBean> mostrarProdutosCategoria(int idCategoria) throws DAOException {
        Connection con = null;
        ArrayList<ProdutoBean> produtos = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from produto where id_categoria = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idCategoria);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                produtos.add(map(rs));
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
        return produtos;
    }
}
