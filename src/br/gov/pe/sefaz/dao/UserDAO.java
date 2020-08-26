package br.gov.pe.sefaz.dao;

import java.util.List;

import br.gov.pe.sefaz.model.User;

public interface UserDAO {
	
	public List<User> getAllUsers() throws DAOException;
	
	public void removeUser(Integer id) throws DAOException;
	
	public void saveUser(User user) throws DAOException;
	
	public User getUserByName(String name) throws DAOException;
	
	
	
	
	
}
