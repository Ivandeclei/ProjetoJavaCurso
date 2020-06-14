package model.dao;

import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	//classe responsavel por instancial os Daos
	
	// retorna o tipo da interface  mas mas instancia um seller dao jdbc 
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC();
	}

}
