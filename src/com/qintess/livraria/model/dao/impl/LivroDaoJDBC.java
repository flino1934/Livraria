package com.qintess.livraria.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.qintess.livraria.db.DB;
import com.qintess.livraria.db.DbException;
import com.qintess.livraria.model.dao.LivroDao;
import com.qintess.livraria.model.entities.Genero;
import com.qintess.livraria.model.entities.Livro;

public class LivroDaoJDBC implements LivroDao {

	private Connection conn;

	public LivroDaoJDBC(Connection conn) {

		this.conn = conn;
	}

	@Override
	public void insert(Livro livro) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Livro livro) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Livro findById(Integer id) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement(
					"SELECT livro.*,genero.DESCRICAO as DESCRICAO "
					+"FROM livro INNER JOIN genero "
					+"ON livro.IDGENERO = genero.IDGENERO "
					+"WHERE livro.IDLIVRO = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if (rs.next()) {
				
				Genero genero = instantiateGenero(rs);
				
				Livro livro = instantiateLivro(rs, genero);
				
				return livro;
			}
			return null;
		}catch(SQLException e) {
			
			throw new DbException(e.getMessage());
			
			
		}finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
		
		
	}

	@Override
	public List<Livro> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Livro> findByDepartment(Genero genero) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Genero instantiateGenero(ResultSet rs) throws SQLException {// Metodo de intanciação do Cliente
		// TODO Auto-generated method stub

		Genero genero = new Genero();
		genero.setDescricao(rs.getString("DESCRICAO"));// vai passar a descricao  que esta no banco para a classe!
		genero.setIdGenero(rs.getInt("IDGENERO"));
		return genero;
		
	}
	
	private Livro instantiateLivro(ResultSet rs,Genero genero) throws SQLException {// Metodo de intanciação do Cliente
		// TODO Auto-generated method stub

		Livro livro = new Livro();
		livro.setIdLivro(rs.getInt("IDLIVRO"));
		livro.setTitulo(rs.getString("TITULO"));
		livro.setPreco(rs.getFloat("PRECO"));
		livro.setEstoque(rs.getInt("ESTOQUE"));
		livro.setGenero(genero);
		return livro;
		
		
	}

}
