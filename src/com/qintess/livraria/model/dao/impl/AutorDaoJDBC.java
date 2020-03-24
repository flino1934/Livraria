package com.qintess.livraria.model.dao.impl;

import java.sql.Connection;
import java.util.List;

import com.qintess.livraria.model.dao.AutorDao;
import com.qintess.livraria.model.entities.Autor;

public class AutorDaoJDBC implements AutorDao{
	
	private Connection conn;

	@Override
	public void insert(Autor autor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Autor autor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Autor findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Autor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
