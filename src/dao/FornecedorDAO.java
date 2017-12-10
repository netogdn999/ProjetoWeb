package dao;

import java.sql.*;
import java.util.ArrayList;

import control.FornecedorBean;

public class FornecedorDAO {
	
	private FornecedorBean map(ResultSet rs) throws SQLException {
        FornecedorBean resultado = new FornecedorBean(rs.getInt("id"),
        		rs.getString("nome_fantasia"), rs.getString("razao_social"),
        		rs.getString("cnpj"), rs.getString("email"),
        		rs.getString("endereco"), rs.getString("cep"),
        		rs.getString("telefone1"), rs.getString("telefone2"),
        		rs.getBoolean("is_autenticado"));
        return resultado;
    }
	
	public void inserir(String nomeFantasia,String razaoSocial, 
			String cnpj, String email, String endereco, String cep,
			String telefone1, String telefone2, boolean isAutenticado) throws DAOException{
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String insert_sql = "insert into fornecedor (nome_fantasia, razao_social, cnpj, email, endereco, cep, telefone1, telefone2, is_autenticado) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst;
            pst = con.prepareStatement(insert_sql);
            //Passando os paramentros para o SQL
            pst.setString(1, nomeFantasia);
            pst.setString(2, razaoSocial);
            pst.setString(3, cnpj);
            pst.setString(4, email);
            pst.setString(5, endereco);
            pst.setString(6, cep);
            pst.setString(7, telefone1);
            pst.setString(8, telefone2);
            pst.setBoolean(9, isAutenticado);
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
	
	public void update(int id, String nomeFantasia,String razaoSocial, 
			String cnpj, String email, String endereco, String cep,
			String telefone1, String telefone2, boolean isAutenticado) throws DAOException{
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String insert_sql = "update fornecedor set nome_fantasia = ?, razao_social = ?, cnpj = ?, email = ?, endereco = ?, cep = ?, telefone1 = ?, telefone2 = ?, is_autenticado  = ? where id = ?";
            PreparedStatement pst;
            pst = con.prepareStatement(insert_sql);
            //Passando os paramentros para o SQL
            pst.setString(1, nomeFantasia);
            pst.setString(2, razaoSocial);
            pst.setString(3, cnpj);
            pst.setString(4, email);
            pst.setString(5, endereco);
            pst.setString(6, cep);
            pst.setString(7, telefone1);
            pst.setString(8, telefone2);
            pst.setBoolean(9, isAutenticado);
            pst.setInt(10, id);
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
            String sql = "delete from fornecedor where id = ?";
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

	public FornecedorBean encontrar(int id) throws DAOException{
        Connection con = null;
        FornecedorBean forn = null;
                
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from fornecedor where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                forn = map(rs);
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
        return forn;
    }
	
	public ArrayList<FornecedorBean> mostrarTodos() throws DAOException {
        Connection con = null;
        ArrayList<FornecedorBean> fornecedores = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from fornecedor";
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                fornecedores.add(map(rs));
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
        return fornecedores;
    }
	public int idUltimoCadastrado() throws DAOException{
       Connection con = null;
       int id;
               
       try {
           con = ConnectionFactory.getConnection();
           String sql = "select max(id) from fornecedor";
           PreparedStatement pst = con.prepareStatement(sql);
           ResultSet rs = pst.executeQuery();
           if (rs.next()) {
               id = rs.getInt("id");
           }
       } catch (SQLException e) {
           throw new DAOException("Opera��o n�o realizada com sucesso.", e);
       } finally {
           try {
               if (con != null) {
                   con.close();
               }
           } catch (SQLException e) {
               throw new DAOException("N�o foi poss�vel fechar a conex�o.", e);
           }
       }
       return id;
   }
	public ArrayList<FornecedorBean> mostrarFornecedoresCategoria(int idCategoria) throws DAOException {
        Connection con = null;
        ArrayList<FornecedorBean> fornecedores = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from fornecedor where id = (select id_fornecedor from fornecedor_categoria where id_categoria = ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idCategoria);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                fornecedores.add(map(rs));
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
        return fornecedores;
    }
}
