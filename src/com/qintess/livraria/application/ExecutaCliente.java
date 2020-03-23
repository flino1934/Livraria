package com.qintess.livraria.application;

import java.util.List;

import javax.swing.JOptionPane;

import com.qintess.livraria.model.dao.ClienteDao;
import com.qintess.livraria.model.dao.DaoFactory;
import com.qintess.livraria.model.entities.Cliente;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClienteDao clienteDao = DaoFactory.createClienteDao();
		

		// ======== Insert Cliente ========
		//Cliente cliente = new Cliente(null,"Sarah","(13)98133-3855");
		//clienteDao.insert(cliente);

		//========= findById cliente ======
		//Cliente cliente = clienteDao.findById(2);
		//System.out.println(cliente);
		
		//=========== Update ===========
		//Cliente cliente = clienteDao.findById(1);
		//cliente.setName("Felipe Lino");
		//cliente.setTelefone("(13) 98137-5682");
		//clienteDao.update(cliente);
		
		//========== Delete ==========
		//int id = Integer.parseInt(JOptionPane.showInputDialog("Delete id: "));
		//clienteDao.deleteById(id);
		
		
		List<Cliente> list = clienteDao.findAll();
		for (Cliente cliente2 : list) {
			
			System.out.println(cliente2);
		
		}
		
	}

}
