package com.qintess.livraria.model.dao;

import com.qintess.livraria.model.dao.impl.ClienteDaoJDBC;

public class DaoFactory {
	
public static ClienteDao createClienteDao() {//vai expor a interface ao inves de expor a implementação 
		
		return new ClienteDaoJDBC(com.qintess.livraria.db.DB.getConnection());//Ele vai te retornar a classe SellerDaoJDBC
		
	}

}
