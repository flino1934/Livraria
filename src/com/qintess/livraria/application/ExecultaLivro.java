package com.qintess.livraria.application;

import java.util.List;

import javax.swing.JOptionPane;

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
		//Genero genero = new Genero(2,null);
		//List<Livro> list = livroDao.findByGenero(genero);
		
		//for (Livro livro : list) {
		//	System.out.println(livro);
		//}
		
		//=========Insert===============
		//Não esquecer de quando for fazer insert Instanciar o genero.
		//Livro livron = new Livro(null,"Quase um Romance",54.9f,8, genero);
		//livroDao.insert(livron);
		//System.out.println("Livro inserido id: "+livron.getIdLivro());
		
		//========Update==========
		//Livro livro2 = livroDao.findById(4);
		//livro2.setTitulo("Pepa pig");
		//livro2.setPreco(29.90f);
		//livro2.setEstoque(17);
		//livroDao.update(livro2);
		
		int id = Integer.parseInt(JOptionPane.showInputDialog("Delete id: "));
		livroDao.deleteById(id);
		
		//========= findAll ==============
		List<Livro> list = livroDao.findAll();
		for (Livro livro : list) {
			System.out.println(livro);
		}
		
		
		
	}

}
