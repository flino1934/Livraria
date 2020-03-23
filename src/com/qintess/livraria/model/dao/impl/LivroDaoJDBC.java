package com.qintess.livraria.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.qintess.livraria.db.DB;
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
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement(
					"INSERT INTO livro "
					+ "(TITULO, PRECO, ESTOQUE, IDGENERO) "
					+ "VALUES "
					+ "(?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1,livro.getTitulo());
			st.setFloat(2,livro.getPreco());
			st.setInt(3,livro.getEstoque());
			st.setInt(4,livro.getIdLivro());
			
			int rowAffected = st.executeUpdate();
			
			if (rowAffected > 0) {
				
				ResultSet rs = st.getGeneratedKeys();
				
				if (rs.next()) {
					
					int id = rs.getInt(1);
					livro.setIdGenero(id);
				}
				DB.closeResultSet(rs);
			}
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}

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
