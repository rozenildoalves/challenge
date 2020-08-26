package br.gov.pe.sefaz.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.pe.sefaz.dao.DAOException;
import br.gov.pe.sefaz.dao.UserDAO;
import br.gov.pe.sefaz.model.Logger;
import br.gov.pe.sefaz.model.Phone;
import br.gov.pe.sefaz.model.User;




@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDAO userDAO;
	
//	public void init() {
//		userDAO = new UserDAO();
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
//			case "/new":
//				showNewForm(request, response);
//				break;
//			case "/insert":
//				insertUser(request, response);
//				break;
//			case "/delete":
//				deleteUser(request, response);
//				break;
//			case "/edit":
//				showEditForm(request, response);
//				break;
//			case "/update":
//				updateUser(request, response);
//				break;
			default:
				try {
					listUser(request, response);
				} catch (DAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, DAOException {
		List<User> listUser = userDAO.getAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}


}
