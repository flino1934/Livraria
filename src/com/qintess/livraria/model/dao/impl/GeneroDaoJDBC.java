package com.qintess.livraria.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
		PreparedStatement st = null;

		try {

			st = conn.prepareStatement(
					"UPDATE genero " +
					"SET DESCRICAO = ? " +
					"WHERE IDGENERO = ?");//Os dados que podem ser alterados apartir do id
			
			st.setString(1, genero.getDescricao());
			st.setInt(2, genero.getIdGenero());

			st.executeUpdate();

		} catch (SQLException e) {

			throw new DbException(e.getMessage());

		} finally {

			DB.closeStatement(st);

		}

	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("DELETE FROM genero WHERE IDGENERO = ?");

			st.setInt(1, id);// vai passar o id que vem como parametro
			st.executeUpdate();

		} catch (SQLException e) {

			throw new DbException(e.getMessage());

		} finally {

			DB.closeStatement(st);

		}

	}

	@Override
	public Genero findById(Integer id) {
		
		
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {

			st = conn.prepareStatement("SELECT * FROM genero WHERE IDGENERO = ?");
			st.setInt(1, id);
			rs = st.executeQuery();//o st vai ser executado fazendo o comando sql, e depois vai cair no resultSet
			
			if (rs.next()) {

				Genero genero = instantiateGenero(rs);//vai chamar o metodo
				
				return genero;//retorna o genero
			}
			
			
		}catch(SQLException e) {
			
			throw new DbException(e.getMessage());
			
		}finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
		
		return null;
	}

	@Override
	public List<Genero> findAll() {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("SELECT * FROM genero ORDER BY DESCRICAO");

			rs = st.executeQuery();

			List<Genero> list = new ArrayList();

			while (rs.next()) {

				Genero genero = instantiateGenero(rs);
				list.add(genero);// vai passar cliente como argumento para lista

			}

			return list;

		} catch (SQLException e) {

			throw new DbException(e.getMessage());

		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}
	
	private Genero instantiateGenero(ResultSet rs) throws SQLException {// Metodo de intanciação do Cliente
		// TODO Auto-generated method stub

		Genero genero = new Genero();
		genero.setDescricao(rs.getString("DESCRICAO"));// vai passar a descricao  que esta no banco para a classe!
		genero.setIdGenero(rs.getInt("IDGENERO"));
		return genero;
		
	}

}
