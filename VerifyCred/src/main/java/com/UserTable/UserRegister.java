package com.UserTable;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Servlet implementation class UserRegister
 */
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
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
		// creates new user
		try {
			if(request.getParameter("uname")!="" && request.getParameter("password")!="" && request.getParameter("password2")!="") {
				if(request.getParameter("password").equals(request.getParameter("password2"))) {
					String UserName = request.getParameter("uname");
					String Password = request.getParameter("password");
					Users users = new Users(UserName, Password);
					SessionFactory factory = HibernateUtil.getSessionFactory();
					Session session = factory.openSession();
					session.save(users);
					response.getWriter().append("User Added Successfully");
					session.close();
				}
				else {
					response.getWriter().append("The passwords do NOT match!");
				}
				
			}
			else if(request.getParameter("uname")=="") {
				response.getWriter().append("Enter User Name");
			}
			else if(request.getParameter("password")=="") {
				response.getWriter().append("Enter Password");
			}
			else if(request.getParameter("password2")=="") {
				response.getWriter().append("Re-Enter Password");
			}
			
		} catch(NumberFormatException nfe)
		{
			response.getWriter().append("Enter Valid Input");
		}
		catch(Exception ex) {
			response.getWriter().append(ex.getLocalizedMessage());
		}
	}

}
