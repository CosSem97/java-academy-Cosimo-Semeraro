package package1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class myServlet
 */
@WebServlet("/myServlet")
public class myServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.setContentType("text/html");
		// PrintWriter out = response.getWriter();
		// out.print("<html><body>");
		// out.print("<h1>Prova<h1>");
		// out.print("</body></html>");
		
		request.getRequestDispatcher("/welcome.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		String user = request.getParameter("user");
		String pwd = request.getParameter("password");
		
		if(user.equals("CosSem97") && pwd.equals("mypassword")) {
			// vai alla pagina del profilo
			request.getRequestDispatcher("/profilo.html").forward(request, response);
		}
		else {
			// vai alla pagina di errore
			request.getRequestDispatcher("/errore.html").forward(request, response);
		}
	}

}
