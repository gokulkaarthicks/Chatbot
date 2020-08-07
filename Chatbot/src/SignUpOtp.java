



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dbutil.Validate;

/**
 * Servlet implementation class OtpAuth
 */
@WebServlet("/SignUpOtp")
public class SignUpOtp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userOtp=request.getParameter("otp");
		HttpSession session=request.getSession();
		String generatedOtp=(String)session.getAttribute("otp");
		String userName=(String)session.getAttribute("username");
		String userPassword=(String)session.getAttribute("userpass");
		String userEmail=(String)session.getAttribute("useremail");
		if(generatedOtp.equals(userOtp)){
			boolean flag=Validate.addUser(userName,userPassword,userEmail);
			session.removeAttribute("otp");
			session.removeAttribute("username");
			session.removeAttribute("useremail");
			session.removeAttribute("userpass");
			if(flag){
				response.sendRedirect("Login.html");
			}else{
				response.sendRedirect("SignUp.jsp");
			}

		}
		else
		response.sendRedirect("SignUpOtp.jsp");
	}

}
