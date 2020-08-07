

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dbutil.Validate;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setAttribute("name", Validate.rowCount());
		//request.getRequestDispatcher("Loggedin.jsp").forward(request, response);
		HttpSession session=request.getSession();
		session.removeAttribute("username");
		session.removeAttribute("password");
		session.invalidate();
		//PrintWriter writer = response.getWriter();
		//writer.println("<script>a("+Validate.rowCount()+")</script>");
		response.sendRedirect("Login.html");
	}


}
