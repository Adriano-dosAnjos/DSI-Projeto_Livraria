package br.edu.up.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.up.model.Cliente;

public class ClienteDAO implements DAO<Cliente>{
	
	@Override
	public Cliente incluir(Cliente cliente) {
		
		try {
			Connection con = Conexao.getConnection();
		
			String sql = "insert into clientes (nome, sobrenome, cpf, data, email) values (?, ?, ?, ?, ?);";
			PreparedStatement executor = con.prepareStatement(sql);
			executor.setString(1, cliente.getNome());
			executor.setString(2, cliente.getSobrenome());
			executor.setString(3, cliente.getCpf());
			executor.setString(4, cliente.getData());
			executor.setString(5, cliente.getEmail());
			
			int retorno = executor.executeUpdate();
			
			executor.close();
			con.close();
			
			System.out.println ("Adicionado com sucesso!");
			
		} catch (SQLException e) {
			System.out.println("Devido a erros na leitura não foi possivel concluir o armazenamento dos dados");
		}
		
		return cliente;
	}

	@Override
	public List<Cliente> listar() {

		List<Cliente> listaDeClientes = new ArrayList<>();
		
		try {
			Connection con = Conexao.getConnection();
			
			Statement executor = con.createStatement();
			String sql = "select * from clientes;";
			ResultSet resultado = executor.executeQuery(sql);
			
			System.out.println ("------------------------------ CLIENTES ------------------------------");
			System.out.println ("");
			System.out.println("\tCodigo" + "\tNOME" + "\t\t\t\t\tCPF" + "\t\tDATA DE NASCIMENTO" + "\t\tEMAIL");
			System.out.println ("");
			while (resultado.next()) {
				
				int id = resultado.getInt("id");
				String nome = resultado.getString("Nome");
				String sobrenome = resultado.getString("Sobrenome");
				String cpf = resultado.getString("CPF");
				String data = resultado.getString("Data");
				String email = resultado.getString("Email");
				
				Cliente c = new Cliente(id, nome, sobrenome, cpf, data, email);
				listaDeClientes.add(c);
			}
			
			executor.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println ("Devido a erros na leitura do banco de dados, não foi possivel listar as informações.");
		}
		
		return listaDeClientes;
	}

	@Override
	public Cliente atualizar(Cliente cliente) {
		
		try {
			Connection con = Conexao.getConnection();
			
			String sql = "update clientes set nome = ?, sobrenome = ?, cpf = ?, data = ?, email = ? where id = ?;";
			PreparedStatement executor = con.prepareStatement(sql);
			executor.setString(1, cliente.getNome());
			executor.setString(2, cliente.getSobrenome());
			executor.setString(3, cliente.getCpf());
			executor.setString(4, cliente.getData());
			executor.setString(5, cliente.getEmail());
			executor.setInt(6, cliente.getId());
			
			int retorno = executor.executeUpdate();
			
			System.out.println ("Alteração concluida com sucesso!");
			
			executor.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("Devido a erros na leitura do banco de dados, não foi possivel concluir as atualizações");
		}
		
		return cliente;
	}

	@Override
	public void excluir(Integer id) {
		try {
			Connection con = Conexao.getConnection();
			
			String sql = "delete from clientes where id = ?;";
			PreparedStatement executor = con.prepareStatement(sql);
			executor.setInt(1, id);
			
			int retorno = executor.executeUpdate();
			
			executor.close();
			con.close();
		
		} catch (SQLException e) {
		System.out.println ("Devido a erros na leitura do banco de dados, não foi possivel excluir as informações.");
		}
		
	}
	
}
