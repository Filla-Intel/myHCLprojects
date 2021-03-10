package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Servlet implementation class PetsServlet
 */
public class PetsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PetsServlet() {
		super();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();

			Session session = factory.openSession();
			List<Product> list = session.createQuery("from Product", Product.class).list();

			session.close();

			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<b>Product Listing</b><br>");
			for (Product p : list) {
				out.println("ID: " + String.valueOf(p.getID()) + ", Name: " + p.getName() + ", Price: "
						+ String.valueOf(p.getPrice()) + ", Color: " + p.getColor().toString() + "<br>");
			}

			out.println("</body></html>");

		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String price = request.getParameter("price");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		try {
			
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			session.beginTransaction();
			
			Product pet = new Product();
			
			if(!name.isEmpty() || !color.isEmpty() || !price.isEmpty()) {
				pet.setName(name);
				pet.setColor(color);
				pet.setPrice(price);
				out.println("<b>Adding Pet</b> " + request.getParameter("name") + "<br>");
				out.println("Click <a href='index.jsp'>here</a> to go back to main page");
			}
			
			session.save(pet);
			session.getTransaction().commit();
			session.close();
			
			
		}catch (Exception e) {
			throw e;
		}	
	}	

	//TODO: Take all parameters from post, and use hibernate to insert new pet.
    // Then you need to print out some confirmation as to the the success/failure.
    // You also need to validate your input and not allow missing / NULL data.

	//doGet(request, response);
}
