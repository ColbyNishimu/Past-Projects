package fabflix;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class mainpage
 */
@WebServlet("/dashboardmainpage.java")
public class dashboardmainpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dashboardmainpage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		fabflix.cart cart = null;
		HttpSession session = request.getSession();
		session.setAttribute("cart",  cart);
		response.setContentType("text/html");
		String button = request.getParameter("button");
		if(button.equals("Insert Star")){
			response.sendRedirect("starAdd.html");
		}else if(button.equals("get metaData")){
			response.sendRedirect("Metadata");
		}else if(button.equals("Add Movie")){
			response.sendRedirect("addMovie.html");
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
