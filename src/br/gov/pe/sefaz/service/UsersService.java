package br.gov.pe.sefaz.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import br.gov.pe.sefaz.dao.AbstractDAOFactory;
import br.gov.pe.sefaz.dao.DAOException;
import br.gov.pe.sefaz.dao.UserDAO;
import br.gov.pe.sefaz.model.Logger;
import br.gov.pe.sefaz.model.User;



public class UsersService {

	private final UserDAO userDAO;
	
	@Context
	private HttpServletRequest request;

	UsersService(final UserDAO userDAO) {	
		this.userDAO = userDAO;		
	}

	
	public UsersService() {		
		this.userDAO = AbstractDAOFactory.getDAOFactory().getUserDAO();
	}
	
	
	public Response getUsers() {
		
		try {
			return Response.ok(userDAO.getAllUsers()).build();
		}
		catch (DAOException exception){
			
			return Response.serverError().entity(new ServiceException(
					"Ocorreu um erro durante o acesso ao Banco de Dados!", exception)).build();
		}
	}
	
	public Response save(User user) throws DAOException {
		
		try {
			
			User currentUser = (User) request.getSession().getAttribute("user");

			if (currentUser.equals(user)) {
				
			}
			
			user.setName(user.getName().toUpperCase());
			
			userDAO.saveUser(user);
			
			return Response.ok().build();
		}
		catch (DAOException exception){
			
			return Response.serverError().entity(new ServiceException(
					"Ocorreu um erro durante o acesso ao Banco de Dados!", exception)).build();
		}
	}
	
//	public Response login(@QueryParam("username") String username, @QueryParam("password") String password) {
//		
//		username = username.toUpperCase();
//		
//		HttpSession session = request.getSession();
//		
//		try {
//			
//			User user = userDAO.getUserByName(username);
//			
//			if (user.getName().equals(username.toString()) && user.getPassword().equals(password)) {
//				
//				user.setLogger(Logger.YES);
//				
//				session.setAttribute("user", user);
//				
//				return Response.ok(user).build();
//			}
//			else {
//				
//				Map<String, String> map = new HashMap<>();
//				
//				map.put("message", "Usuario ou senha invalidos!");
//				
//				return Response.ok(map).build();
//			}
//		}
//		catch (DAOException exception) {
//			
//			return Response.serverError().entity(new ServiceException(
//					"Ocorreu um erro durante o acesso ao Banco de Dados!", exception)).build();
//		}
//	
//	}
	
	public User login(String username, String password) throws DAOException {
		
		username = username.toUpperCase();
		
		HttpSession session = request.getSession();
		
		User user = new User();
		
		try {
			
			user = userDAO.getUserByName(username);
			
			if (user.getName().equals(username.toString()) && user.getPassword().equals(password)) {
				
				user.setLogger(Logger.YES);	
				
				session.setAttribute("user", user);
				
			
				return user;
			} 
		}
		catch (Exception exception) {
			throw new DAOException(exception);
		}
		
		return user;
	
	}
	
	
}