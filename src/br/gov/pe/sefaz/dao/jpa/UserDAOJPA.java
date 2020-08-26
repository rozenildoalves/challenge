package br.gov.pe.sefaz.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import br.gov.pe.sefaz.dao.DAOException;
import br.gov.pe.sefaz.dao.UserDAO;
import br.gov.pe.sefaz.model.User;

public class UserDAOJPA implements UserDAO {
	
	private final EntityManagerFactory entityManagerFactory;
	
	UserDAOJPA(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public List<User> getAllUsers() throws DAOException {

		EntityManager entityManager = null;
		
		try {
			
			entityManager = entityManagerFactory.createEntityManager();
			
			TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
			
			List<User> users = query.getResultList();	
			
			return users;
			
		}
		catch (Exception exception) {
			throw new DAOException(exception);
		}		
		finally{
			
			if ((entityManager != null) && (entityManager.isOpen())) {
				entityManager.close();
			}
		}
	}

	@Override
	public void removeUser(Integer id) throws DAOException {
		
		EntityManager entityManager = null;
		
		try {
			
			entityManager = entityManagerFactory.createEntityManager();
			
			TypedQuery<User> query = entityManager.createQuery(
					"delete u from User u where u.id = :id", User.class);
			
			query.setParameter("id", id);
			
		}
		catch (Exception exception) {
			throw new DAOException(exception);
		}		
		finally{
			
			if ((entityManager != null) && (entityManager.isOpen())) {
				entityManager.close();
			}
		}
		
	}

	@Override
	public void saveUser(User user) throws DAOException {
		
		EntityManager entityManager = null;
		
		try {
			
			entityManager = entityManagerFactory.createEntityManager();
			
			entityManager.getTransaction().begin();
			
			user  = entityManager.merge(user);
			
			entityManager.getTransaction().commit();
		}
		catch(Exception exception) {
			
			entityManager.getTransaction().rollback();
			
			throw new DAOException(exception);
		}
		finally {
			
			if ((entityManager != null) && (entityManager.isOpen())) {
				entityManager.close();
			}
		}
		
	}

	@Override
	public User getUserByName(String name) throws DAOException {

		EntityManager entityManager = null;
		
		try {
			
			entityManager = entityManagerFactory.createEntityManager();
			
			TypedQuery<User> query = entityManager.createQuery(
					"select u from User u where u.name = :name", User.class);
			
			query.setParameter("name", name);
			
			User user = query.getSingleResult();
			
			return user;
			
		}
		catch (Exception exception) {
			throw new DAOException(exception);
		}		
		finally{
			
			if ((entityManager != null) && (entityManager.isOpen())) {
				entityManager.close();
			}
		}
		
		
		
	}


}
