package com.qintess.livraria.model.dao;

import java.util.List;

import com.qintess.livraria.model.entities.Cliente;

public interface ClienteDao {

	void insert(Cliente cliente);

	void update(Cliente cliente);

	void deleteById(Integer id);
	
	Cliente findById(Integer id);// vai consultar se tem o id solicitado
	
	List<Cliente> findAll();// vai retornar todos os Clientes

}
