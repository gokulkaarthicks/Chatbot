

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dbutil.*;
import com.otp.auth.SendEmail;

@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("username");
		String userPassword=request.getParameter("userpass");
		String userEmail=request.getParameter("useremail");
		String otp=SendEmail.getOtp((String)userEmail, 0);
		HttpSession session=request.getSession();
		session.setAttribute("otp", otp);
		session.setAttribute("username",userName);
		session.setAttribute("userpass",userPassword);
		session.setAttribute("useremail",userEmail);
		response.sendRedirect("SignUpOtp.jsp");
	}

}
