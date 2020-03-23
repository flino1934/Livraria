package com.qintess.livraria.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.qintess.livraria.db.DbException;
import com.qintess.livraria.model.dao.LivroDao;
import com.qintess.livraria.model.entities.Livro;

public class LivroDaoJDBC implements LivroDao {

	private Connection conn;

	public LivroDaoJDBC(Connection conn) {

		this.conn = conn;
	}

	@Override
	public void insert(Livro livro) {

	}

	@Override
	public void update(Livro livro) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Livro livro) {
		// TODO Auto-generated method stub

	}

	@Override
	public Livro findById(Livro livro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Livro> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
