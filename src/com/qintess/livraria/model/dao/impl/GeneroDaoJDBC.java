package com.qintess.livraria.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.qintess.livraria.db.DB;
import com.qintess.livraria.db.DbException;
import com.qintess.livraria.model.dao.GeneroDao;
import com.qintess.livraria.model.entities.Genero;

public class GeneroDaoJDBC implements GeneroDao {

	private Connection conn;

	public GeneroDaoJDBC(Connection conn) {

		this.conn = conn;
	}

	@Override
	public void insert(Genero genero) {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement(
					"INSERT INTO genero "
					+ "(DESCRICAO) "
					+ "VALUES "
					+ "(?)",Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1,genero.getDescricao());
			
			int rowAffected = st.executeUpdate();
			
			if (rowAffected > 0) {
				
				ResultSet rs = st.getGeneratedKeys();
				
				if (rs.next()) {

					int id = rs.getInt(1);// Vai pegar o id
					genero.setIdGenero(id);// Vai passar o id
				}

				DB.closeResultSet(rs);

			}

		} catch (SQLException e) {

			throw new DbException(e.getMessage());

		}
		DB.closeStatement(st);
	}

	@Override
	public void update(Genero genero) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Genero genero) {
		// TODO Auto-generated method stub

	}

	@Override
	public Genero findById(Genero genero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Genero> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
