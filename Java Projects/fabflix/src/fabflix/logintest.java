package fabflix;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.net.*;
import java.util.*;
import java.sql.*;
import fabflix.verifyRecaptcha;

@WebServlet("/logintest.java")
public class logintest extends HttpServlet{
	Connection conn = null;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		   response.setContentType("text/html");
		   PrintWriter out = response.getWriter();
		   String email = request.getParameter("email");
		   String user = request.getParameter("user");
		   String password = request.getParameter("password");
		   String recaptchaResponse = request.getParameter("g-recaptcha-response");
		   String g = "com.mysql.jdbc.Driver";
		   boolean verify = verifyRecaptcha.verify(recaptchaResponse);
			try {
				Class.forName(g);
				conn = DriverManager.getConnection("jdbc:mysql://localhost/moviedb", "testuser", "testpass");
			} catch (ClassNotFoundException e) {
				System.out.println("ClassNotFoundException : "+e.getMessage());
			} catch (SQLException e){
				System.out.println(e.getMessage());
			}
			if(user.equals("user")){
				String q = (String.format("SELECT * FROM customers WHERE email = %s AND password = %s", '"'+email+'"', '"'+password+'"'));
				try{
					Statement query = conn.createStatement();
					ResultSet result = query.executeQuery(q);
				if(result.next()&&verify){
					response.sendRedirect("mainpage.html");
				} else{
					System.out.println("failed");
					RequestDispatcher rd = request.getRequestDispatcher("index.html");
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
			if(user.equals("member")){
				String q = (String.format("SELECT * FROM employees WHERE email = %s AND password = %s", '"'+email+'"', '"'+password+'"'));
				try{
					Statement query = conn.createStatement();
					ResultSet result = query.executeQuery(q);
				if(result.next()){
					response.sendRedirect("dashboardmain.html");
				} else{
					System.out.println("failed");
					RequestDispatcher rd = request.getRequestDispatcher("_dashboard.html");
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
}

