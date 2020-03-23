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
import com.qintess.livraria.model.dao.ClienteDao;
import com.qintess.livraria.model.entities.Cliente;

public class ClienteDaoJDBC implements ClienteDao {

	private Connection conn;

	public ClienteDaoJDBC(Connection conn) {

		this.conn = conn;

	}

	@Override
	public void insert(Cliente cliente) {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement(
					"INSERT INTO cliente "
							+"(NOME, TELEFONE) " 
							+"VALUES " 
							+"(?, ?)",Statement.RETURN_GENERATED_KEYS);
			//Vamos passar 3 valores no insert, pois o id vai ser gerado automaticamente.
			
			st.setString(1,cliente.getName());
			st.setString(2,cliente.getTelefone());
			
			int rowAffected = st.executeUpdate();

			if (rowAffected > 0) {

				ResultSet rs = st.getGeneratedKeys();

				if (rs.next()) {

					int id = rs.getInt(1);// Vai pegar o id
					cliente.setId(id);// vai atribuir o id ao cliente
					
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
	public void update(Cliente cliente) {
		
		PreparedStatement st = null;

		try {

			st = conn.prepareStatement(
					"UPDATE cliente " +
					"SET NOME = ?, TELEFONE = ? " +
					"WHERE IDCLIENTE = ?");//Os dados que podem ser alterados apartir do id
			
			st.setString(1, cliente.getName());
			st.setString(2, cliente.getTelefone());
			st.setInt(3, cliente.getId());

			st.executeUpdate();

		} catch (SQLException e) {

			throw new DbException(e.getMessage());

		} finally {

			DB.closeStatement(st);

		}

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement(
					"DELETE FROM cliente WHERE IDCLIENTE = ?");
			
			st.setInt(1,id);//vai passar o id que vem como parametro
			st.executeUpdate();
			
		}catch(SQLException e) {
			
			throw new DbException(e.getMessage());
			
		}finally {
			
			DB.closeStatement(st);
			
		}

	}

	@Override
	public Cliente findById(Integer id) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {

			st = conn.prepareStatement("SELECT * FROM cliente WHERE IDCLIENTE = ?");
			st.setInt(1,id);
			rs = st.executeQuery();//o st vai ser executado fazendo o comando sql, e depois vai cair no resultSet
			
			if (rs.next()) {

				Cliente cliente = instantiateDepartment(rs);//vai chamar o metodo
				
				return cliente;//retorna o obj
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
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement(
					"SELECT * FROM cliente ORDER BY NOME");
			
			rs = st.executeQuery();

			List<Cliente> list = new ArrayList();

			while (rs.next()) {

				Cliente cliente = instantiateDepartment(rs);
				list.add(cliente);// vai passar cliente como argumento para lista

			}

			return list;

		} catch (SQLException e) {

			throw new DbException(e.getMessage());

		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
		
	}

	private Cliente instantiateDepartment(ResultSet rs) throws SQLException {// Metodo de intanciação do Cliente
		// TODO Auto-generated method stub

		Cliente cliente = new Cliente();
		cliente.setId(rs.getInt("IDCLIENTE"));// vai passar o ID que esta no banco para a classe!
		cliente.setName(rs.getString("NOME"));// vai passar o nome do cliente para a classe!
		cliente.setTelefone(rs.getString("TELEFONE"));// vai passar o telefone para a classe!
		return cliente;
	}

}
