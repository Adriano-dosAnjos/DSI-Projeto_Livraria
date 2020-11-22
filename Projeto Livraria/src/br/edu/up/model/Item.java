package br.edu.up.model;

public class Item {

	private int codigo;
	private String titulo;
	private String autor;
	private String editora;
	private int edicao;
	private String ano;
	private String genero;
	
	private int id;
	private String cpf;
	private String nome;
	private String sobrenome;
	private String data;
	private String email;
	
	public Item() {
		
	}
	
	
	public Item(String titulo, String autor, String editora, int edicao, String ano, String genero) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.edicao = edicao;
		this.ano = ano;
		this.genero = genero;
	}

	


	public Item(int codigo, String titulo, String autor, String editora, int edicao, String ano, String genero) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.edicao = edicao;
		this.ano = ano;
		this.genero = genero;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public int getEdicao() {
		return edicao;
	}
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	@Override
	public String toString() {
		return String.format("%5s - %-47s %-39s %-25s %-5s %-7s %-30s", codigo, titulo, autor, editora, edicao, ano, genero);
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public Item(String nome, String sobrenome, String cpf, String data, String email) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.data = data;
		this.email = email;
	}


	public Item(int id, String nome, String sobrenome,String cpf, String data, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.data = data;
		this.email = email;
	}
	
	
	
}
