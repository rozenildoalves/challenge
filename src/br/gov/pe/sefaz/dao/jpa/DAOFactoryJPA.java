package br.gov.pe.sefaz.dao.jpa;



import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.gov.pe.sefaz.dao.DAOFactory;
import br.gov.pe.sefaz.dao.UserDAO;

public class DAOFactoryJPA implements DAOFactory {

	private static final String PERSISTENCE_UNIT_NAME = "user";
	
	private final EntityManagerFactory entityManagerFactory;
	
	public DAOFactoryJPA() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}


	@Override
	public UserDAO getUserDAO() {
		return new UserDAOJPA(entityManagerFactory);
	}
	


}



