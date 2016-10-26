package br.com.drogaria.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//parametros de conexao
public class ConexaoFactory {
	private static final String USUARIO = "root";
	private static final String SENHA = "123456";
	private static final String URL = "jdbc:mysql://localhost:3306/drogaria?useSSL=false";

	// Abre conexao com banco nas variaveis
	public static Connection conectar() throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}

	// testa a conexao
	public static void main(String[] args) {
		try {
			Connection conexao = ConexaoFactory.conectar();
			System.out.println("Conexao realizada com sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Não foi possivel realizar a conexao!");
		}
	}

}