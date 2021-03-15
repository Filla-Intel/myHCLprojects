package com.UserTable;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
/**
 * Servlet implementation class LoginServlet
 */
public class UserAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserAuth() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//logs the user into the database or gives error message
		try {
			if(request.getParameter("uname")!="" && request.getParameter("password")!="") {
				String userName = request.getParameter("uname");
				String password = request.getParameter("password");
				SessionFactory factory = HibernateUtil.getSessionFactory();

				Session session = factory.openSession();
				String hql = "from Users where UserName = :user_Name";
				Query query = session.createQuery(hql);
				query.setParameter("user_Name", userName);
				Users user = (Users) query.list().stream().findFirst().orElse(null);
				if(user != null) {
					if(user.getPassword().equals(password)) {
						request.getRequestDispatcher("LandingPage.jsp").forward(request, response);
					}
					else {
						response.getWriter().append("Password is incorrect");
					}
				}
				else {
					response.getWriter().append("Invalid User Name");
				}
			}
			else if(request.getParameter("uname")=="") {
				response.getWriter().append("Enter User Name");
			}
			else if(request.getParameter("password")=="") {
				response.getWriter().append("Enter Password");
			}
		}catch(Exception ex) {

		}
	}

}
