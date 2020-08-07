

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class OtpAuth
 */
@WebServlet("/OtpAuth")
public class OtpAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userOtp=request.getParameter("otp");
		HttpSession session=request.getSession();
		String check=(String)session.getAttribute("role");
		System.out.println(check+" "+userOtp);
		String generatedOtp=(String)session.getAttribute("otp");
		if(generatedOtp.equals(userOtp)){
			if(check.equals("user"))
				response.sendRedirect("chat.html");
			else
				response.sendRedirect("Loggedin.jsp");
				
		}
		else
		response.sendRedirect("otp.jsp");
	}

}
