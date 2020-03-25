package com.qintess.livraria.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qintess.livraria.db.DB;
import com.qintess.livraria.db.DbException;
import com.qintess.livraria.model.dao.VendaDao;
import com.qintess.livraria.model.entities.Cliente;
import com.qintess.livraria.model.entities.Venda;

public class VendaDaoJDBC implements VendaDao {

	private Connection conn;

	public VendaDaoJDBC(Connection conn) {

		this.conn = conn;
	}

	@Override
	public void insert(Venda venda) {

		PreparedStatement st = null;
		
		try {
		
			st = conn.prepareStatement(
					"INSERT INTO venda "
					+ "(DATA, TOTAL, IDCLIENTE) "
					+ "VALUES "
					+ "(?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
			
			st.setDate(1,new java.sql.Date(venda.getData().getTime()));
			st.setFloat(2, venda.getTotal());
			st.setInt(3,venda.getCliente().getId());

			int rowAffecteds = st.executeUpdate();

			if (rowAffecteds > 0) {

				ResultSet rs = st.getGeneratedKeys();

				if (rs.next()) {

					int id = rs.getInt(1);
					venda.setIdVenda(id);

				}

				DB.closeResultSet(rs);

			} else {
				throw new DbException("Nenhuma linha alterada");
			}

		} catch (SQLException e) {

			throw new DbException(e.getMessage());

		} finally {

			DB.closeStatement(st);

		}
		

	}

	@Override
	public void update(Venda venda) {
		PreparedStatement st = null;
		
		try {
		
			st = conn.prepareStatement(
					  "UPDATE VENDA "
					+ "SET DATA = ?, TOTAL = ?, IDCLIENTE = ? "
					+ "WHERE IDVENDA = ?");
			
			st.setDate(1, new java.sql.Date(venda.getData().getTime()));
			st.setFloat(2, venda.getTotal());
			st.setInt(3,venda.getCliente().getId());
			st.setInt(4,venda.getIdVenda());
			
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

			st = conn.prepareStatement("DELETE FROM venda WHERE IDVENDA = ?");

			st.setInt(1, id);

			st.executeUpdate();

		} catch (SQLException e) {

			throw new DbException(e.getMessage());

		} finally {

			DB.closeStatement(st);

		}

	}

	@Override
	public Venda findById(Integer id) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement(//Vai pesquisar pelo id do livro e trazer os dados deles com join na tabela genero
					"SELECT venda.*,cliente.NOME as NOME "
					+"FROM venda INNER JOIN cliente "
					+"ON venda.IDCLIENTE = cliente.IDCLIENTE "
					+"WHERE venda.IDVENDA = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if (rs.next()) {
				
				Cliente cliente = instantiateCliente(rs);
			
				Venda venda = instantiateVenda(rs, cliente);
				
				return venda;
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
	public List<Venda> findAll() {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement(//Vai pesquisar pelo id do livro e trazer os dados deles com join na tabela genero
					"SELECT venda.*,cliente.NOME as NOME "
					+"FROM venda INNER JOIN cliente "
					+"ON venda.IDCLIENTE = cliente.IDCLIENTE "
					+"ORDER BY NOME");
			
			
			rs = st.executeQuery();
			
			List<Venda> list = new ArrayList<>();
			Map<Integer,Cliente> map = new HashMap<>();
			//Usar o map pois assim vai dar para verificar se existe a referencia na memoria e assim vai apontar apenas para um local para
			//não ter que criar varios objetos na memoria
			
			while (rs.next()) {

				//Vai testar se o genero ja exiiste.
				Cliente cli = map.get(rs.getInt("IDCLIENTE"));//Vai pegar o id do genero, caso ele não encontre o o id do genero ele vai retornar nullo
					
				if (cli == null) {
					
					cli = instantiateCliente(rs);//se não existir vai instanciar
					map.put(rs.getInt("IDCLIENTE"), cli);
				}

				Venda venda = instantiateVenda(rs, cli);
				list.add(venda);

			}
			return list;
		} catch (SQLException e) {

			throw new DbException(e.getMessage());

		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}

	}

	
	
	private Venda instantiateVenda(ResultSet rs,Cliente cliente) throws SQLException {// Metodo de intanciação do Cliente
		// TODO Auto-generated method stub

		Venda venda = new Venda();
		venda.setIdVenda(rs.getInt("IDVENDA"));
		venda.setData(rs.getDate("DATA"));
		venda.setTotal(rs.getFloat("TOTAL"));
		venda.setCliente(cliente);

		return venda;

	}

	private Cliente instantiateCliente(ResultSet rs) throws SQLException {// Metodo de intanciação do Cliente
		// TODO Auto-generated method stub

		Cliente cliente = new Cliente();

		cliente.setName(rs.getString("NOME"));// vai passar o nome do cliente para a classe!
		//cliente.setTelefone(rs.getString("TELEFONE"));// vai passar o telefone para a classe!
		cliente.setId(rs.getInt("IDCLIENTE"));// vai passar o ID que esta no banco para a classe!
		return cliente;
	}

}
