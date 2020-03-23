package com.qintess.livraria.application;

import com.qintess.livraria.model.dao.DaoFactory;
import com.qintess.livraria.model.dao.GeneroDao;
import com.qintess.livraria.model.entities.Genero;

public class ExecultaLivro {

	public static void main(String[] args) {
		
		GeneroDao generoDao = DaoFactory.createGeneroDao();
		Genero genero = new Genero(null,"Aventura");
		generoDao.insert(genero);
		
	}
	
}
