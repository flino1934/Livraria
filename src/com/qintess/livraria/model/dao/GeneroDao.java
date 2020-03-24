package com.qintess.livraria.model.dao;

import java.util.List;

import com.qintess.livraria.model.entities.Genero;

public interface GeneroDao {
	
	void insert(Genero genero);

	void update(Genero genero);

	void deleteById(Integer id);
	
	Genero findById(Integer id);// vai consultar se tem o id solicitado
	
	List<Genero> findAll();// vai retornar todos os Clientes

}
