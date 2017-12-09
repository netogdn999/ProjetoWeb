package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private Connection con = null;
	private String caminho = "jdbc:mysql://localhost:3306/";
	private String usuario = "root";
	private String senha = "toor";
	
	public ConnectionFactory() {
		super();
	}
	
	public Connection conectar(String banco) throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				con = DriverManager.getConnection(caminho + banco, usuario, senha);
			} catch (SQLException e) {
				System.out.println("Caminho, senha ou usu�rio incorretos");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Driver n�o encontrado");
		}
		return con;
	}
	
	public Connection getConnection() {
		return con;
	}
}
