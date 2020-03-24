package com.qintess.livraria.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			
			st = conn.prepareStatement(//Vai pesquisar pelo id do livro e trazer os dados deles com join na tabela genero
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
	public List<Livro> findByGenero(Genero genero) {
	
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement(//Vai pesquisar pelo id do livro e trazer os dados deles com join na tabela genero
					"SELECT livro.*,genero.DESCRICAO as DESCRICAO "
					+"FROM livro INNER JOIN genero "
					+"ON livro.IDGENERO = genero.IDGENERO "
					+"WHERE genero.IDGENERO = ? "
					+"ORDER BY TITULO");
			
			st.setInt(1, genero.getIdGenero());
			rs = st.executeQuery();
			
			List<Livro> list = new ArrayList<>();
			Map<Integer,Genero> map = new HashMap<>();
			//Usar o map pois assim vai dar para verificar se existe a referencia na memoria e assim vai apontar apenas para um local para
			//não ter que criar varios objetos na memoria
			
			while (rs.next()) {

				//Vai testar se o genero ja exiiste.
				Genero gen = map.get(rs.getInt("IDGENERO"));//Vai pegar o id do genero, caso ele não encontre o o id do genero ele vai retornar nullo
					
				if (gen == null) {
					
					gen = instantiateGenero(rs);//se não existir vai instanciar
					map.put(rs.getInt("IDGENERO"), gen);
				}

				Livro livro = instantiateLivro(rs, gen);
				list.add(livro);

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
