package com.qintess.livraria.application;

import java.util.List;

import com.qintess.livraria.model.dao.ClienteDao;
import com.qintess.livraria.model.dao.DaoFactory;
import com.qintess.livraria.model.entities.Cliente;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClienteDao clienteDao = DaoFactory.createClienteDao();
		//Cliente cliente = new Cliente();

		// Insert Cliente
		// cliente = new Cliente(null, "Lucas", "3012-2551");
		// clienteDao.insert(cliente);

		//findById cliente
		//Cliente cliente = clienteDao.findById(2);
		//System.out.println(cliente);
		
		List<Cliente> list = clienteDao.findAll();
		for (Cliente cliente2 : list) {
			System.out.println(cliente2);
		}
		
	}

}
