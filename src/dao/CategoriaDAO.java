package dao;

import java.sql.*;
import java.util.ArrayList;

import control.CategoriaBean;


public class CategoriaDAO {
	
	
	private CategoriaBean map(ResultSet rs) throws SQLException {
        CategoriaBean resultado = new CategoriaBean(rs.getInt("id"), rs.getString("nome"));
        return resultado;
    }
	
	public void inserir(String nome) throws DAOException{
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String insert_sql = "insert into categoria (nome) values (?)";
            PreparedStatement pst;
            pst = con.prepareStatement(insert_sql);
            //Passando os paramentros para o SQL
            pst.setString(1, nome);
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
	public void inserirFornecedorCategoria(int idCategoria, int idFornecedor) throws DAOException{
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String insert_sql = "insert into fornecedor_categoria (id_categoria, id_fornecedor) values (?)";
            PreparedStatement pst;
            pst = con.prepareStatement(insert_sql);
            //Passando os paramentros para o SQL
            pst.setInt(1, idCategoria);
            pst.setInt(2, idFornecedor);
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
	public void update(int id, String nome) throws DAOException{
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String insert_sql = "update categoria set nome = ? where id = ?";
            PreparedStatement pst;
            pst = con.prepareStatement(insert_sql);
            //Passando os paramentros para o SQL
            pst.setString(1, nome);
            pst.setInt(2, id);
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

    public void deleteFornecedorCategoria(int idCategoria, int idFornecedor) throws DAOException{
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "delete from fornecedor_categoria where id_categoria = ? and id_fornecedor = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idCategoria);
            pst.setInt(2, idFornecedor);
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
    public void delete(int id) throws DAOException{
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "delete from categoria where id = ?";
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

	public CategoriaBean encontrar(int id) throws DAOException{
        Connection con = null;
        CategoriaBean cat = null;
                
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from categoria where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                cat = map(rs);
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
        return cat;
    }
	
	public ArrayList<CategoriaBean> mostrarTodas() throws DAOException {
        Connection con = null;
        ArrayList<CategoriaBean> categorias = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from categoria";
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                categorias.add(map(rs));
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
        return categorias;
    }
	
	public ArrayList<CategoriaBean> mostrarCategoriasFornecedor(int idFornecedor) throws DAOException {
        Connection con = null;
        ArrayList<CategoriaBean> categorias = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from categoria where id = (select id_categoria from fornecedor_categoria where id_fornecedor = ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idFornecedor);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                categorias.add(map(rs));
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
        return categorias;
    }
	
	public CategoriaBean mostrarCategoriaProduto(int idProduto) throws DAOException{
        Connection con = null;
        CategoriaBean cat = null;
                
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from categoria where id = (select id_categoria from produto where id = ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idProduto);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                cat = map(rs);
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
        return cat;
    }
}
