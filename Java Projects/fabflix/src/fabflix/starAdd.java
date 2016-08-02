package fabflix;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class starAdd
 */
@WebServlet("/starAdd")
public class starAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public starAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String pURL = request.getParameter("photo_url");
		String[] temp = name.split(" ");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/moviedb", "testuser", "testpass");
			if(temp.length == 1){
				try{
					Statement query = conn.createStatement();
					int result = query.executeUpdate(String.format("INSERT INTO stars (first_name, last_name, dob, photo_url) VALUES ('', %s, %s, %s)", '"'+temp[0]+'"', '"'+dob+'"', '"'+pURL+'"'));
					response.sendRedirect("dashboardmain.html");
				} catch (SQLException e){
					System.out.println("Bad sql");
					e.printStackTrace();
				}
			} else if(temp.length == 2){
				try{
					Statement query = conn.createStatement();
					int result = query.executeUpdate(String.format("INSERT INTO stars (first_name, last_name, dob, photo_url) VALUES (%s, %, %s, %s)", '"'+temp[0]+'"', '"'+temp[1]+'"', '"'+dob+'"', '"'+pURL+'"'));
					response.sendRedirect("dashboardmain.html");
				} catch (SQLException e){
					e.printStackTrace();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
