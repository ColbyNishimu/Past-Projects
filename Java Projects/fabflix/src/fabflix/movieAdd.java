package fabflix;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class movieAdd
 */
@WebServlet("/movieAdd")
public class movieAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public movieAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String title = request.getParameter("title");
		String year = request.getParameter("year");
		String director = request.getParameter("director");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String genre = request.getParameter("genre");
		out.println("<html><body>");
		out.println("<head>Adding movie...</head>");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/moviedb", "testuser", "testpass");
			out.println("Connected to database");
			CallableStatement cs = conn.prepareCall("{call add_Movie(?, ?, ?, ?, ?, ?, ?)}");
			cs.setString(1, first_name);
			cs.setString(2, last_name);
			cs.setString(3, genre);
			cs.setString(4, title);
			cs.setString(5, year);
			cs.setString(6, director);
			cs.registerOutParameter(7, Types.VARCHAR);
			cs.execute();
			out.println(cs.getString(7));
			out.println("<br><br>Success!");
		}catch(Exception e){
			e.printStackTrace();
			out.println("Something went wrong");
		}
		
		out.println("<form action='returnButton' method='POST'>");
		out.println("<input type='submit' name='button' value='Return to dashboard'></form></body></html>");
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
