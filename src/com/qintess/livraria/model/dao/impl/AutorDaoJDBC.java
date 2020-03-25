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
import com.qintess.livraria.model.dao.AutorDao;
import com.qintess.livraria.model.entities.Autor;
import com.qintess.livraria.model.entities.Cliente;

public class AutorDaoJDBC implements AutorDao {

	private Connection conn;

	public AutorDaoJDBC(Connection conn) {

		this.conn = conn;
	}

	@Override
	public void insert(Autor autor) {
		
		PreparedStatement st = null;

		try {

			st = conn.prepareStatement(
					"INSERT INTO autor "
							+"(NOME, EMAIL) " 
							+"VALUES " 
							+"(?, ?)",Statement.RETURN_GENERATED_KEYS);
			//Vamos passar 3 valores no insert, pois o id vai ser gerado automaticamente.
			
			st.setString(1,autor.getNome());
			st.setString(2,autor.getEmail());
			
			int rowAffected = st.executeUpdate();

			if (rowAffected > 0) {

				ResultSet rs = st.getGeneratedKeys();

				if (rs.next()) {

					int id = rs.getInt(1);// Vai pegar o id
					autor.setIdAutor(id);// vai atribuir o id ao cliente
					
				}

				DB.closeResultSet(rs);

			} else {
				throw new DbException("Nenhuma linha foi Inserida");
			}
		} catch (SQLException e) {

			throw new DbException(e.getMessage());

		} finally {

			DB.closeStatement(st);

		}

	}

	@Override
	public void update(Autor autor) {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement(
					"UPDATE autor " +
					"SET NOME = ?, EMAIL = ? " +
					"WHERE IDAUTOR = ?");//Os dados que podem ser alterados apartir do id
			
			st.setString(1, autor.getNome());
			st.setString(2, autor.getEmail());
			st.setInt(3, autor.getIdAutor());

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
			
			st = conn.prepareStatement(
					"DELETE FROM autor WHERE IDAUTOR = ?");
			
			st.setInt(1,id);//vai passar o id que vem como parametro
			st.executeUpdate();
			
		}catch(SQLException e) {
			
			throw new DbException(e.getMessage());
			
		} finally {

			DB.closeStatement(st);

		}

	}

	@Override
	public Autor findById(Integer id) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {

			st = conn.prepareStatement("SELECT * FROM autor WHERE IDAUTOR = ?");
			st.setInt(1,id);
			rs = st.executeQuery();//o st vai ser executado fazendo o comando sql, e depois vai cair no resultSet
			
			if (rs.next()) {

				Autor autor = instantiateAutor(rs);//vai chamar o metodo
				
				return autor;//retorna o obj
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
	public List<Autor> findAll() {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement(
					"SELECT * FROM autor ORDER BY NOME");
			
			rs = st.executeQuery();

			List<Autor> list = new ArrayList();

			while (rs.next()) {

				Autor autor = instantiateAutor(rs);
				list.add(autor);// vai passar cliente como argumento para lista

			}

			return list;

		} catch (SQLException e) {

			throw new DbException(e.getMessage());

		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}
	
	private Autor instantiateAutor(ResultSet rs) throws SQLException {// Metodo de intanciação do Cliente
		// TODO Auto-generated method stub

		Autor autor = new Autor();
		autor.setIdAutor(rs.getInt("IDAUTOR"));// vai passar o ID que esta no banco para a classe!
		autor.setNome(rs.getString("NOME"));
		autor.setEmail(rs.getString("EMAIL"));
		return autor;
	}

}
