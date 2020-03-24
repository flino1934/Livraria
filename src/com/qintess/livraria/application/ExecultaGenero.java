package com.qintess.livraria.application;

import java.util.List;

import javax.swing.JOptionPane;

import com.qintess.livraria.model.dao.DaoFactory;
import com.qintess.livraria.model.dao.GeneroDao;
import com.qintess.livraria.model.entities.Genero;

public class ExecultaGenero {

	public static void main(String[] args) {

		GeneroDao generoDao = DaoFactory.createGeneroDao();

		// =========== Insert =========
		// Genero genero = new Genero(null,"Porno");
		// generoDao.insert(genero);

		// ========== findyById ==============
		// Genero genero = generoDao.findById(1);
		// System.out.println(genero);
		
		//========= Update ============
		//Genero genero = generoDao.findById(4);
		//genero.setDescricao("Ficção");
		//generoDao.update(genero);
		
		//========= Delete =========
		int id = Integer.parseInt(JOptionPane.showInputDialog("Delete id: "));
		generoDao.deleteById(id);		
		
		//========== findByAll ========
		List <Genero> genero = generoDao.findAll();
		
		for (Genero genero2 : genero) {
			System.out.println(genero2);
		}
		
	}

}
