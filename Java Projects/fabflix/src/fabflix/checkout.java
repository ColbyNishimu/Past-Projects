package fabflix;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class checkout
 */
@WebServlet("/checkout")
public class checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkout() {
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
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		cart shoppingCart = (cart)session.getAttribute("cart");
		Set set = shoppingCart.movieCart.entrySet();
		Iterator i = set.iterator();
		out.println("<html><body>");
		out.println("Your Cart:<br><br>");
		while(i.hasNext()){
			Map.Entry j = (Map.Entry)i.next();
			out.println(j.getKey() + ": "+j.getValue()+"<br><br>");
		}
		out.println("<form action='checkout1.html' method='POST'>");
		out.println("<input type='submit' name='button' value='Next'>");
		out.println("</form>");
		out.println("</body></html>");
	}
	

}
