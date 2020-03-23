package com.qintess.livraria.model.dao;

import java.util.List;

import com.qintess.livraria.model.entities.Livro;

public interface LivroDao {
	
	void insert(Livro livro);

	void update(Livro livro);

	void deleteById(Livro livro);
	
	Livro findById(Livro livro);// vai consultar se tem o id solicitado
	
	List<Livro> findAll();// vai retornar todos os Livros

}
