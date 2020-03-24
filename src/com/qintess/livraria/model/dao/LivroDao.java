package com.qintess.livraria.model.dao;

import java.util.List;

import com.qintess.livraria.model.entities.Genero;
import com.qintess.livraria.model.entities.Livro;

public interface LivroDao {

	void insert(Livro livro);

	void update(Livro livro);

	void deleteById(Integer id);

	Livro findById(Integer id);// vai consultar se tem o id solicitado

	List<Livro> findAll();// vai retornar todos os livros(Classe livro)

	List<Livro> findByDepartment(Genero genero);// Vai retornar todos os generos solicitados(classe genero).

	
}
