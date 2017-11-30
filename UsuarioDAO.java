import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {
	
	private UsuarioBean map(ResultSet rs) throws SQLException {
        UsuarioBean resultado = new UsuarioBean(rs.getInt("id"), rs.getString("nome"),
        		rs.getString("login"), rs.getString("senha"),
        		rs.getString("cpf"), rs.getString("setor"));
        return resultado;
    }
	
	public void inserir(String nome, String login, String senha, String cpf, String setor) throws DAOException{
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String insert_sql = "insert into usuario (nome, login, senha, cpf, setor) values (?, ?, ?, ?, ?)";
            PreparedStatement pst;
            pst = con.prepareStatement(insert_sql);
            //Passando os paramentros para o SQL
            pst.setString(1, nome);
            pst.setString(2, login);
            pst.setString(3, senha);
            pst.setString(4, cpf);
            pst.setString(5, setor);
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
	
	public void update(int id, String nome, String login, String senha, String cpf, String setor) throws DAOException{
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String insert_sql = "update usuario set nome = ?, login = ?, senha = ?, cpf = ?, setor = ? where id = ?";
            PreparedStatement pst;
            pst = con.prepareStatement(insert_sql);
            //Passando os paramentros para o SQL
            pst.setString(1, nome);
            pst.setString(2, login);
            pst.setString(3, senha);
            pst.setString(4, cpf);
            pst.setString(5, setor);
            pst.setInt(6, id);
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
            String sql = "delete from usuario where id = ?";
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

	public UsuarioBean encontrar(int id) throws DAOException{
        Connection con = null;
        UsuarioBean usuario = null;
                
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from usuario where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
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
            con = ConnectionFactory.getConnection();
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
