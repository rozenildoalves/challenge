package br.gov.pe.sefaz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.pe.sefaz.dao.DAOException;
import br.gov.pe.sefaz.model.User;
import br.gov.pe.sefaz.service.UsersService;



@WebServlet("/login")
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public Login() {}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");	
		
		try {
			UsersService usersService = new UsersService();	
			
			User user = usersService.login(username.toString(), password.toString());
			
			request.getRequestDispatcher("jsp/list.jsp").forward(request, response);
			
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
				

	}

}
