package br.edu.up.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.up.model.Item;

public class ItemDAO implements DAO<Item> {

	@Override
	public Item incluir(Item item) {
		
		try {
			Connection con = Conexao.getConnection();
			String sql = "insert into clientes (nome, sobrenome, cpf, data, email) values (?, ?, ?, ?, ?);";
			PreparedStatement executor = con.prepareStatement(sql);
			executor.setString(1, item.getNome());
			executor.setString(2, item.getSobrenome());
			executor.setString(3, item.getCpf());
			executor.setString(4, item.getData());
			executor.setString(5, item.getEmail());
			
			int retorno = executor.executeUpdate();
			
			executor.close();
			con.close();
			
			System.out.println ("Adicionado com sucesso!");
			
			
		} catch (SQLException e) {
			System.out.println("Devido a erros na leitura não foi possivel concluir o armazenamento dos dados");
		};
		
		return item;
	}

	@Override
	public List<Item> listar() {
		
		List<Item> listaDeItens = new ArrayList<>();
				
		try {
			Connection con = Conexao.getConnectionlivraria();
			Statement executor = con.createStatement();
			String sql = "select * from Livraria;";
			ResultSet resultado = executor.executeQuery(sql);
			
			System.out.println ("---------------------------------------------------------------------- PRODUTOS ---------------------------------------------------------------------- ");
			System.out.println ("");
			System.out.println("Codigo" + "\tTitulo" + "\t\t\t\t\t\tAutor" + "\t\t\t\t\tEditora" + "\t\t\tEdicao" + "\tAno" + "\tGenero" );
			System.out.println ("");
			
			while (resultado.next()) {
				int codigo = resultado.getInt("codigo");
				String titulo = resultado.getString("titulo");
				String autor = resultado.getString("autor");
				String editora = resultado.getString("editora");
				int edicao = resultado.getInt("edicao");
				String ano = resultado.getString("ano");
				String genero = resultado.getString("genero");
				
				Item i = new Item (codigo, titulo, autor, editora, edicao, ano, genero);
				listaDeItens.add(i);
				
			}
			
			executor.close();
			con.close();
			
			
		} catch (SQLException e) {
			System.out.println("Devido a erros na leitura do banco de dados, não foi possivel listar a relação de produtos.");
		}

		return listaDeItens;
	}

	@Override
	public Item atualizar(Item entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(Integer id) {
		// TODO Auto-generated method stub
		
	}


	
	
}
