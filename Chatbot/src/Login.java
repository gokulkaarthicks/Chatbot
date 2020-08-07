

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dbutil.*;
import com.otp.auth.SendEmail;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("username");
		String userPassword=request.getParameter("userpass");
		String check=Validate.checkUser(userName,userPassword);
		if(request.getParameter("log-in") != null){
			if(check!=null){
				HttpSession session=request.getSession();
				session.setAttribute("username", userName);
				session.setAttribute("password", userPassword);
				session.setAttribute("role", check);
				String email=Validate.getEmail(userName, userPassword);
				String generatedOtp=SendEmail.getOtp(email,0);
				session.setAttribute("otp", generatedOtp);
				response.sendRedirect("otp.jsp");
			}
			else{
				response.sendRedirect("Login.html");
			}
		}
		else if(request.getParameter("chat-bot") != null)
			response.sendRedirect("chat.html");
		else{
			response.sendRedirect("SignUp.jsp");
		}
	}


}
