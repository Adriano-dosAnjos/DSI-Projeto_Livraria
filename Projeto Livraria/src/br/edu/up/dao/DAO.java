package br.edu.up.dao;

import java.util.List;

public interface DAO<T>{

	T incluir (T entidade);
	List<T> listar();
	T atualizar (T entidade);
	void excluir (Integer id);
	
}
