import java.sql.*;
import java.util.ArrayList;

public class FornecedorDAO {
	
	private FornecedorBean map(ResultSet rs) throws SQLException {
        FornecedorBean resultado = new FornecedorBean(rs.getInt("id"),
        		rs.getString("nome_fantasia"), rs.getString("razao_social"),
        		rs.getString("cnpj"), rs.getString("cpf"), rs.getString("email"),
        		rs.getString("endereco"), rs.getString("cep"),
        		rs.getString("telefone1"), rs.getString("telefone2"),
        		rs.getString("responsavel"), rs.getString("login"),
        		rs.getString("senha"));
        return resultado;
    }
	
	public void inserir(String nomeFantasia,String razaoSocial, 
			String cnpj, String cpf, String email, String endereco, String cep,
			String telefone1, String telefone2, String responsavel,
			String login, String senha) throws DAOException{
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String insert_sql = "insert into fornecedor (nome_fantasia, razao_social, cnpj, cpf, email, endereco, cep, telefone1, telefone2, responsavel, login, senha) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst;
            pst = con.prepareStatement(insert_sql);
            //Passando os paramentros para o SQL
            pst.setString(1, nomeFantasia);
            pst.setString(2, razaoSocial);
            pst.setString(3, cnpj);
            pst.setString(4, cpf);
            pst.setString(5, email);
            pst.setString(6, endereco);
            pst.setString(7, cep);
            pst.setString(8, telefone1);
            pst.setString(9, telefone2);
            pst.setString(10, responsavel);
            pst.setString(11, login);
            pst.setString(12, senha);
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
			String cnpj, String cpf, String email, String endereco, String cep,
			String telefone1, String telefone2, String responsavel,
			String login, String senha) throws DAOException{
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String insert_sql = "update fornecedor set nome_fantasia = ?, razao_social = ?, cnpj = ?, cpf = ?, email = ?, endereco = ?, cep = ?, telefone1 = ?, telefone2 = ?, responsavel = ?, login = ?, senha  = ? where id = ?";
            PreparedStatement pst;
            pst = con.prepareStatement(insert_sql);
            //Passando os paramentros para o SQL
            pst.setString(1, nomeFantasia);
            pst.setString(2, razaoSocial);
            pst.setString(3, cnpj);
            pst.setString(4, cpf);
            pst.setString(5, email);
            pst.setString(6, endereco);
            pst.setString(7, cep);
            pst.setString(8, telefone1);
            pst.setString(9, telefone2);
            pst.setString(10, responsavel);
            pst.setString(11, login);
            pst.setString(12, senha);
            pst.setInt(13, id);
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
