package com.qintess.livraria.model.dao;

import java.util.List;

import com.qintess.livraria.model.entities.Autor;

public interface AutorDao {
	
	void insert(Autor autor);

	void update(Autor autor);

	void deleteById(Integer id);
	
	Autor findById(Integer id);// vai consultar se tem o id solicitado
	
	List<Autor> findAll();// vai retornar todos os Generos

}
