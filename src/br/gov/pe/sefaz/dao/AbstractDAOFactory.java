package br.gov.pe.sefaz.dao;

import br.gov.pe.sefaz.dao.jpa.DAOFactoryJPA;

public abstract class AbstractDAOFactory {

	private static DAOFactory daoFactory;
	
	public static DAOFactory getDAOFactory() {
		
		if (daoFactory == null) {
			daoFactory = new DAOFactoryJPA();
		}

		return daoFactory;
	}
	
}