package br.edu.up.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static final String URL = "jdbc:sqlite:C:\\Users\\adfer\\OneDrive\\Documentos\\Universidade Positivo\\2° Semestre\\Desenvolvimento de Software 1\\2° Bimestre\\Projeto\\Dados-Cliente.db";
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL);
		
	}
	
	private static final String URL2 = "jdbc:sqlite:C:\\Users\\adfer\\OneDrive\\Documentos\\Universidade Positivo\\2° Semestre\\Desenvolvimento de Software 1\\2° Bimestre\\Projeto\\Livraria.db";
	public static Connection getConnectionlivraria() throws SQLException {
		return DriverManager.getConnection(URL2);
		
	}
}
