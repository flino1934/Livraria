package com.qintess.livraria.application;

import java.util.List;

import com.qintess.livraria.model.dao.DaoFactory;
import com.qintess.livraria.model.dao.LivroDao;
import com.qintess.livraria.model.entities.Livro;

public class ExecultaLivro {
	
	public static void main(String[] args) {
		
		LivroDao livroDao = DaoFactory.createLivroDao();
		
		//===========FindByID=============
		
		//Livro livro = livroDao.findById(1);
		//System.out.println(livro);
		
		//========= findByGenero ==========
		//Genero genero = new Genero(3,null);
		//List<Livro> list = livroDao.findByGenero(genero);
		
		//for (Livro livro : list) {
		//	System.out.println(livro);
		//}
		
		//========= findAll ==============
		List<Livro> list = livroDao.findAll();
		for (Livro livro : list) {
			System.out.println(livro);
		}
		
		
	}

}
