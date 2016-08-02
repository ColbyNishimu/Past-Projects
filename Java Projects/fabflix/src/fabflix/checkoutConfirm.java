package fabflix;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class checkoutConfirm
 */
@WebServlet("/checkoutConfirm")
public class checkoutConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkoutConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Connection conn = null;
		PrintWriter out = response.getWriter();
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String ccnum = request.getParameter("ccnum");
		String exp = request.getParameter("exp");
		String g = "com.mysql.jdbc.Driver";
		try {
			Class.forName(g);
			conn = DriverManager.getConnection("jdbc:mysql://localhost/moviedb", "testuser", "testpass");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException : "+e.getMessage());
		} catch (SQLException e){
			System.out.println(e.getMessage());
		}
		HttpSession session = request.getSession();
		cart shoppingCart = (cart)session.getAttribute("cart");
		Set set = shoppingCart.movieCart.entrySet();
		String q = (String.format("SELECT DISTINCT customers.id FROM creditcards, customers WHERE creditcards.id=customers.cc_id AND customers.first_name = %s AND customers.last_name = %s AND customers.cc_id = %s AND creditcards.expiration = %s", '"'+first_name+'"', '"'+last_name+'"', '"'+ccnum+'"', '"'+exp+'"'+";"));
		try{
			Statement query = conn.createStatement();
			ResultSet result = query.executeQuery(q);
		if(result.next()){
			int customerid = result.getInt(1);
			Iterator i = set.iterator();
			while(i.hasNext()){
				Map.Entry j = (Map.Entry)i.next();
				Statement query1 = conn.createStatement();
				String q1 = "SELECT id FROM movies WHERE title ="+'"'+j.getKey()+'"'+";";
				ResultSet result1 = query1.executeQuery(q1);
				result1.next();
				Integer id = result1.getInt(1);
				for(int h =0;h < (Integer)j.getValue();h++){
					Statement query2 = conn.createStatement();
					DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date date = new Date();
					String dateres = format.format(date);
					String q2 = "INSERT INTO sales (customer_id, movie_id, sale_date) VALUES ("+'"'+customerid+'"'+","+'"'+id+'"'+","+'"'+dateres+'"'+");";
					query2.executeUpdate(q2);
				}
				out.println(j.getKey() + ": "+j.getValue()+"<br><br>");
			}
			response.sendRedirect("checkout2.html");
		} else{
			System.out.println("failed");
			RequestDispatcher rd = request.getRequestDispatcher("checkout1.html");
			rd.forward(request, response);  
	    }
	        result.close();
	        query.close();
	        conn.close();
		}catch(Exception e){
			e.printStackTrace();	
		}finally{
		}
	}

}
