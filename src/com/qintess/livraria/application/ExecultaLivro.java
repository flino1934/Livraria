package com.qintess.livraria.application;

import com.qintess.livraria.model.dao.DaoFactory;
import com.qintess.livraria.model.dao.LivroDao;
import com.qintess.livraria.model.entities.Livro;

public class ExecultaLivro {
	
	public static void main(String[] args) {
		
		LivroDao livroDao = DaoFactory.createLivroDao();
		
		//===========FindByID=============
		
		Livro livro = livroDao.findById(1);
		System.out.println(livro);
		
		
	}

}
