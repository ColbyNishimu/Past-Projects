package fabflix;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Metadata
 */
@WebServlet("/Metadata")
public class Metadata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Metadata() {
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
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/moviedb", "testuser", "testpass");
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<head>Metadata</head>");
			String[] tables = {"movies", "stars", "stars_in_movies", "genres", "genres_in_movies", "customers", "sales", "creditcards", "employees"};
			for(int i = 0; i < tables.length; i++){
				Statement select = conn.createStatement();
				ResultSet result = select.executeQuery(String.format("SELECT * FROM %s", tables[i]));
				ResultSetMetaData metadata = result.getMetaData();
				out.println("Table name is "+metadata.getTableName(1));
				for (int j = 1; j <= metadata.getColumnCount(); j++)
					out.println("Type of column " + metadata.getColumnName(j) + " is " + metadata.getColumnTypeName(j));
				out.println();
			}
			out.println("<form action='returnButton' method='POST'>");
			out.println("<input type='submit' name='button' value='Return to dashboard'></form></body></html>");
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
