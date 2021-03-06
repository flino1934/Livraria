package com.qintess.livraria.model.dao;

import com.qintess.livraria.model.dao.impl.AutorDaoJDBC;
import com.qintess.livraria.model.dao.impl.ClienteDaoJDBC;
import com.qintess.livraria.model.dao.impl.GeneroDaoJDBC;
import com.qintess.livraria.model.dao.impl.LivroDaoJDBC;
import com.qintess.livraria.model.dao.impl.VendaDaoJDBC;

public class DaoFactory {
	
public static ClienteDao createClienteDao() {//vai expor a interface ao inves de expor a implementação 
		
		return new ClienteDaoJDBC(com.qintess.livraria.db.DB.getConnection());//Ele vai te retornar a classe ClienteDaoJDBC

	}

public static GeneroDao createGeneroDao(){//vai expor a interface ao inves de expor a implementação 
	
	return new GeneroDaoJDBC(com.qintess.livraria.db.DB.getConnection());//Ele vai te retornar a classe ClienteDaoJDBC

	}

public static LivroDao createLivroDao (){//vai expor a interface ao inves de expor a implementação 
	
	return new LivroDaoJDBC(com.qintess.livraria.db.DB.getConnection());//Ele vai te retornar a classe LivroDaoJDBC

	}

public static AutorDao createAutorDao(){//vai expor a interface ao inves de expor a implementação 
	
	return new AutorDaoJDBC(com.qintess.livraria.db.DB.getConnection());//Ele vai te retornar a classe AutorDaoJDBC

	}

public static VendaDao creatVendaDao(){//vai expor a interface ao inves de expor a implementação 
	
	return new VendaDaoJDBC(com.qintess.livraria.db.DB.getConnection());//Ele vai te retornar a classe AutorDaoJDBC

	}

}
