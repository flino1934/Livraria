package com.qintess.livraria.application;

import java.util.Date;
import java.util.List;

import com.qintess.livraria.model.dao.DaoFactory;
import com.qintess.livraria.model.dao.VendaDao;
import com.qintess.livraria.model.entities.Venda;

public class ExecultaVenda {
	
	public static void main(String[] args) {
		
		VendaDao vendaDao = DaoFactory.creatVendaDao();
		
		//========FindByID===========
		//Venda venda = vendaDao.findById(2);
		//System.out.println(venda);
		
		//=========Insert===============
		//Cliente cliente = new Cliente(1,null,null);
		//Venda venda = new Venda(null, new Date(),120.90f, cliente);
		//vendaDao.insert(venda);
		
		//int id = Integer.parseInt(JOptionPane.showInputDialog("Delete id: "));
		//vendaDao.deleteById(id);
		
		Venda venda2 = vendaDao.findById(2);
		System.out.println(venda2);
		venda2.setData(new Date());
		vendaDao.update(venda2);
		
		//List<Venda> list = vendaDao.findAll();
		
		//for (Venda venda : list) {
			//System.out.println(venda);
		//}
		
		
	}

}
