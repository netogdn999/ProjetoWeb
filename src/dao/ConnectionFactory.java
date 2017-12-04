package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection con = null;
	private static String caminho = "jdbc:postgresql://localhost:5432/";
	private static String usuario = "postgres";
	private static String senha = "toor";
	//postgres jdbc connection
	
	public static Connection conectar(String banco) throws SQLException{
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
	
	public static Connection getConnection() {
		return con;
	}
}
