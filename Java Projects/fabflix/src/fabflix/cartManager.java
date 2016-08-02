package fabflix;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.*;

/**
 * Servlet implementation class cartManager
 */
@WebServlet("/cartManager")
public class cartManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cartManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String button = request.getParameter("button");
		HttpSession session = request.getSession();
		cart shoppingCart = (cart)session.getAttribute("cart");
		String title = request.getParameter("mtitle");
		if(button.equals("+")){
			shoppingCart.add(title);
			System.out.println("added to "+title+": "+shoppingCart.getCart().get(title));
			session.setAttribute("cart", shoppingCart);
		}else if(button.equals("-")){
			shoppingCart.remove(title);
			session.setAttribute("cart", shoppingCart);
		}
		response.sendRedirect(request.getHeader("referer"));
		//RequestDispatcher rd = getServletContext().getRequestDispatcher((String)request.getAttribute("javax.servlet.forward.request_url"));
		//rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String title = request.getParameter("title");
		HttpSession session = request.getSession();
		cart shoppingCart = (cart)session.getAttribute("cart");
		shoppingCart.add(title);
		session.setAttribute("cart", shoppingCart);
		response.sendRedirect(request.getHeader("referer"));
	}

}
