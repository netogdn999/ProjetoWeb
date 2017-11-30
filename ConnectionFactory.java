import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection con = null;
	public static String caminho = "jdbc:postgresql://localhost:5432/";
	public static String usuario = "postgres";
	public static String senha = "toor";
	//postgres jdbc connection
	
	public static Connection getConnection(String banco) throws SQLException{
		try {
			Class.forName("org.postgresql.Driver");
			try {
				con = DriverManager.getConnection(caminho+banco, usuario, senha);
			}catch(SQLException e) {
				throw new SQLException("Caminho, senha ou usuario incorretos");
			}
		}catch(ClassNotFoundException e) {
			throw new ClassCastException("Driver nao encontrado");
		}
		return con;
	}
}
