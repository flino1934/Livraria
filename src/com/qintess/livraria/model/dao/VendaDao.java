package com.qintess.livraria.model.dao;

import java.util.List;

import com.qintess.livraria.model.entities.Cliente;
import com.qintess.livraria.model.entities.Venda;

public interface VendaDao {

	void insert(Venda venda);

	void update(Venda venda);

	void deleteById(Integer id);

	Venda findById(Integer id);// vai consultar se tem o id solicitado

	List<Venda> findAll();// vai retornar todos os livros(Classe livro)

}
