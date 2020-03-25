package com.qintess.livraria.application;

import java.util.List;

import com.qintess.livraria.model.dao.AutorDao;
import com.qintess.livraria.model.dao.DaoFactory;
import com.qintess.livraria.model.entities.Autor;

public class ExecutaAutor {
	
	public static void main(String[] args) {
		
		AutorDao autorDao = DaoFactory.createAutorDao();
		
		//========== findByID ===========
		//Autor autor = autorDao.findById(1);
		//System.out.println(autor);
		
		//=========== Insert ===========
		//Autor autor = new Autor(null,"Masashi Kishimoto", "masashi@gmail.com");
		//autorDao.insert(autor);
		//System.out.println(autor);
		
		//========== INSERT ==============
		//Autor autor = autorDao.findById(1);
		//autor.setEmail("masashi@hotmail.com");
		//autorDao.update(autor);
		//System.out.println(autor);
		
		//========= deleteByID ==========
		//int id = Integer.parseInt(JOptionPane.showInputDialog("Delete id: "));
		//autorDao.deleteById(id);
		
		List<Autor> list = autorDao.findAll();
		
		for (Autor autor : list) {
			System.out.println(autor);
		}
		
	}

}
