package fabflix;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class search
 */
@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String pageNum = request.getParameter("pagenum");
		String rpp = request.getParameter("rpp");
		String sort = request.getParameter("sort");
		PrintWriter out = response.getWriter();
		String q = "SELECT DISTINCT movies.id, title, year, director FROM movies, stars, stars_in_movies WHERE stars.id=stars_in_movies.star_id AND movies.id=stars_in_movies.movie_id AND ";
		String title = request.getParameter("title");
		String year = request.getParameter("year");
		String director = request.getParameter("director");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		int count = 0;
		HttpSession session = request.getSession();
		session.setAttribute("pageNum", pageNum);
		session.setAttribute("rpp", rpp);
		session.setAttribute("sort", sort);
		cart shoppingCart = (cart)session.getAttribute("cart");
		if(shoppingCart == null){
			shoppingCart = new cart();
			session.setAttribute("cart", shoppingCart);
		}
		shoppingCart.printCart();
		if(!title.equals("")){
			q = q+"title="+'"'+title+'"'+" AND ";
			count++;
		}
		if(!year.equals("")){
			q = q+"year="+'"'+year+'"'+" AND ";
			count++;
		}
		if(!director.equals("")){
			q = q+"director="+'"'+director+'"'+" AND ";
			count++;
		}
		if(!first_name.equals("")){
			q = q+"first_name="+'"'+first_name+'"'+" AND ";
			count++;
		}
		if(!last_name.equals("")){
			q = q+"last_name="+'"'+last_name+'"'+" AND ";
			count++;
		}
		if(count != 0){
			q=q.substring(0, q.length() - 5);
		}
		q = q+" ORDER BY ";
		if(sort.equals("tasc")){
			q = q+"title ASC";
		}
		else if(sort.equals("tdes")){
			q = q+"title DESC";
		}
		else if(sort.equals("yasc")){
			q = q+"year ASC";
		}
		else if(sort.equals("ydesc")){
			q = q+"year ASC";
		}
		q=q+";";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/moviedb", "testuser", "testpass");
			Statement query = conn.createStatement();
			ResultSet result = query.executeQuery(q);
			out.println("<html><body>");
			out.println("<script language='javascript' type ='text/javascript'>");
			out.println("function ajaxHover(id){");
			out.println("var ajaxRequest;");
			out.println("try{");
			out.println("ajaxRequest = new XMLHttpRequest{};");
			out.println("{ catch(e){");
			out.println("}");
			out.println("ajaxRequest.onreadystatechange = function(id){");
			out.println("if (xhttp.readyState == 4 && xhttp.status == 200){");
			out.println("document.getElementById('').innerHTML = xhttp.responseText;");
			out.println("}");
			out.println("};");
			out.println("xhttp.open('POST', 'ajaxinfo.java', true);");
			out.println("xhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');");
			out.println("xhttp.send('movieid='+id);");
			out.println("}</script>");
			out.println(shoppingCart.printCart());
			out.println("<head><style>");
			out.println("table, th, td {border: 1px solid black;border-collapse:collapse;}");
			out.println("th, td{padding: 5px;}</style></head>");
			out.println("<table style='width:100%'>");
			out.println("<tr>");
			out.println("<th>ID</th>");
			out.println("<th><form action='searchManager' method='POST'><a href="+'"'+'"'+">Title</a>"+
						"<input type='hidden' name='sort' value="+'"'+sort+'"'+">"+
						"<input type='hidden' name='type' value='title'>"+
						"</form></th>");
			out.println("<th><form action='searchManager' method='POST'><a href="+'"'+'"'+">Year</a>"+
						"<input type='hidden' name='sort' value="+'"'+sort+'"'+">"+
						"<input type='hidden' name='type' value='year'>"+
						"</form></th>");
			out.println("<th>Director</th>");
			out.println("<th>Genres</th>");
			out.println("<th>Stars</th>");
			out.println("<th></th>");
			out.println("</tr>");
			while(result.next()){
				String id = Integer.toString(result.getInt(1));
				String thistitle = result.getString(2);
				out.println("<tr>");
				out.println("<td>"+result.getInt(1)+"</td>");
				out.println("<td>"+result.getString(2)+"</td>");
				out.println("<td>"+result.getInt(3)+"</td>");
				out.println("<td>"+result.getString(4)+"</td>");
				Statement query2 = conn.createStatement();
				ResultSet genres = query2.executeQuery("SELECT genres.name FROM genres, genres_in_movies WHERE movie_id = "+'"'+id+'"'+" AND genres.id=genres_in_movies.genre_id;");
				out.print("<td>");
				String genreString = "";
				while(genres.next()){
					genreString = genreString+genres.getString(1)+", ";
				}
				if(!genreString.equals("")){
					genreString = genreString.substring(0, genreString.length()-2);
				}
				out.println(genreString+"</td>");
				out.print("<td>");
				String starString = "";
				Statement query3 =conn.createStatement();
				ResultSet stars = query3.executeQuery("SELECT stars.first_name, stars.last_name FROM stars, stars_in_movies WHERE stars.id=stars_in_movies.star_id AND movie_id = "+'"'+id+'"'+";");
				while(stars.next()){
					starString = starString+stars.getString(1)+" "+stars.getString(2)+", ";
				}
				if(!starString.equals("")){
					starString = starString.substring(0, starString.length()-2);
				}
				out.println(starString+"</td>");
				out.println("<td>");
				out.println("<form action='cartManager' method='POST'>");
				out.println("<input type='submit' name='button' value='Add to cart'>");
				out.println("<input type='hidden' name='title' value="+'"'+thistitle+'"'+">");
				out.println("</form>");
				out.println("</td></tr>");
			}
			out.println("</table>");
			out.println("<form action='search' method='GET'>");
			//out.println("<a href='http://localhost:8080/homework_2/search">);
			out.println("Results per page: ");
			out.println("<select>");
			out.println("<option value='10'>10</option>");
			out.println("<option value='10'>25</option>");
			out.println("<option value='10'>50</option>");
			out.println("<option value='10'>100</option>");
			out.println("</select>");
			out.println("<input type='submit' name='button' value='Previous'>");
			out.println("<input type='submit' name='button' value='Next'>");
			out.println("</form>");
			out.println("</body></html>");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
	{
		doGet(request, response);
	}
}
